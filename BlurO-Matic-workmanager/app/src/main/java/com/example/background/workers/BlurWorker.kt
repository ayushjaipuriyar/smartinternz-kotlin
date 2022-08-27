package com.example.background.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import android.util.Log.e
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.background.KEY_IMAGE_URI
import com.example.background.R
import java.util.*

class BlurWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        val appContext = applicationContext

        // get the URI we passed in from the Data object.
        val resourceUri = inputData.getString(KEY_IMAGE_URI)
        makeStatusNotification("Image Blurrin", appContext)
        // ADD THIS TO SLOW DOWN THE WORKER
        sleep()
        return try {

            if (TextUtils.isEmpty(resourceUri)) {
              //  Timer.e("Invalid input uri")
                throw IllegalArgumentException("Invalid input uri")
            }

            val resolver = appContext.contentResolver

            val picture = BitmapFactory.decodeStream(
                resolver.openInputStream(Uri.parse(resourceUri)))

            val output = blurBitmap(picture, appContext)

            // Write bitmap to a temp file
            val outputUri = writeBitmapToFile(appContext, output)
            //new Data storing outputUri as a String.
            val outputData = workDataOf(KEY_IMAGE_URI to outputUri.toString())
            Result.success(outputData)
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            Result.failure()
        }
    }

}
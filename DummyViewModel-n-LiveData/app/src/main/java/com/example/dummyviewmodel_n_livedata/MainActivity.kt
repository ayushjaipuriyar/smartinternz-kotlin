package com.example.dummyviewmodel_n_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dummyviewmodel_n_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainActivityViewModel =  ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.numbertv.observe(this, Observer {
            binding.textView.text = it.toString()
        })
        mainActivityViewModel.checkNumbers.observe(this, Observer {
            binding.CheckOddEven.text = it.toString()
        })

        binding.button.setOnClickListener {
            mainActivityViewModel.number = mainActivityViewModel.number + 1
            mainActivityViewModel.setNumber()
            mainActivityViewModel.updateBoolean()
        }
    }
}
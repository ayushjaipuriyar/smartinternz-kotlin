package com.example.dummyviewmodel_n_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var number = 0

    private val _numbers = MutableLiveData<Int>()
    val numbertv: LiveData<Int> = _numbers

    private val _checkNumbers = MutableLiveData<String>()
    val checkNumbers: LiveData<String> = _checkNumbers

    fun updateBoolean() {
        if (numbertv.value!! % 2 != 0) {
            _checkNumbers.value = "ODD"
        } else {
            _checkNumbers.value = "EVEN"
        }
    }

    fun setNumber() {
        _numbers.value = number
    }
}
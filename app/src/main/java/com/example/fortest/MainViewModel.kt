package com.example.fortest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    var text = MutableLiveData<String>().apply { value = "" }

    fun changeText(text:String) {
        this.text.value = text
    }

}
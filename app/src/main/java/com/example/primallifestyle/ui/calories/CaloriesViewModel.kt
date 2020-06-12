package com.example.primallifestyle.ui.calories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CaloriesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is a Calories Fragment"
    }
    val text: LiveData<String> = _text
}
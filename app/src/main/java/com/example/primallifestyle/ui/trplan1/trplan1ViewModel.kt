package com.example.primallifestyle.ui.trplan1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class trplan1ViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {

    }
    val text: LiveData<String> = _text
}
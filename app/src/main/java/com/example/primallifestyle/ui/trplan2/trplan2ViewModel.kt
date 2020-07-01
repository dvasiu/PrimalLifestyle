package com.example.primallifestyle.ui.trplan2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class trplan2ViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {

    }
    val text: LiveData<String> = _text
}
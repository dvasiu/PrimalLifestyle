package com.example.primallifestyle.ui.trainingsplan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrainingsplanViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is trainingsplan Fragment"
    }
    val text: LiveData<String> = _text
}
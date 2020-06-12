package com.example.primallifestyle.ui.myprofile_edit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.primallifestyle.ui.database.PrimalDatabaseDao


class MyProfileViewModelEdit (
    val database: PrimalDatabaseDao, application: Application): AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
    }
    val text: LiveData<String> = _text


}
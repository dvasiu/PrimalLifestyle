package com.example.primallifestyle.ui.myprofile

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.primallifestyle.ui.database.PrimalDatabaseDao
import com.example.primallifestyle.ui.myprofile_edit.MyProfileViewModelEdit

class MyProfileViewModelFactoryEdit(
    private val dataSource: PrimalDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyProfileViewModelEdit::class.java)) {
            return MyProfileViewModelEdit(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


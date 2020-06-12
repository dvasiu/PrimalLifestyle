package com.example.primallifestyle.ui.myprofile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.primallifestyle.ui.database.PrimalData
import com.example.primallifestyle.ui.database.PrimalDatabase
import com.example.primallifestyle.ui.database.PrimalDatabaseDao



class MyProfileViewModel (application: Application) : AndroidViewModel(application) {
    init {
    val dao = PrimalDatabase.getInstance(application).primalDatabaseDao
        //val user1 = dao.getUser(1);
        val user1 = PrimalData(1, "kristian", 20, 80.0, "m", 20.0, 20, 50.0)
       // val newuser = dao.insert(user1)
       // println(newuser)

       // val userfromdb = dao.getUser("kristian")
       // println(userfromdb)
}



}
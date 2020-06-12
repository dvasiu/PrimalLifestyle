package com.example.primallifestyle.ui.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.primallifestyle.ui.database.PrimalData

@Dao
interface PrimalDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(primal: PrimalData)

    @Update
    fun update(primal: PrimalData)

    @Query("SELECT * from primal_database WHERE primalId = :key")
    fun getUser(key: Long): LiveData<List<PrimalData>>

    @Query("DELETE FROM primal_database")
    fun clear()

//    @Query("SELECT * FROM primal_database ORDER BY primalId DESC")
//    fun getAllNights(): LiveData<List<PrimalData>>
//
//    @Query("SELECT * FROM primal_database ORDER BY primalId DESC LIMIT 1")
//    fun getTonight(): PrimalData?

}


package com.example.android.primallifestyle.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PrimalData::class], version = 1, exportSchema = false)
abstract class PrimalDatabase : RoomDatabase() {

    abstract val primalDatabaseDao: PrimalDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: PrimalDatabase? = null

        fun getInstance(context: Context): PrimalDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PrimalDatabase::class.java,
                        "primal_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

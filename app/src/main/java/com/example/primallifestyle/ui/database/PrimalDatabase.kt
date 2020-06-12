package com.example.primallifestyle.ui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [PrimalData::class], version = 1, exportSchema = false)
abstract class PrimalDatabase : RoomDatabase() {

    abstract val primalDatabaseDao: PrimalDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: PrimalDatabase? = null

        fun getInstance(
            context: Context
        ): PrimalDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PrimalDatabase::class.java,
                    "primal_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }
}

package com.example.primallifestyle.ui.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "primal_database")
data class PrimalData(
    @PrimaryKey(autoGenerate = true)
    var primalId: Int,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "age")
    var age: Int,

    @ColumnInfo(name = "weight")
    var weight: Double,

    @ColumnInfo(name = "gender")
    var gender: String,

    @ColumnInfo(name = "bmi")
    var bmi: Double,

    @ColumnInfo(name = "calories")
    var calories: Int,

    @ColumnInfo(name = "primalScore")
    var primalScore: Double

)

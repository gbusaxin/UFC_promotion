package com.example.ufcpromotion.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_p4p")
class P4PDbModel(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val image: String,
    val weight: String
)
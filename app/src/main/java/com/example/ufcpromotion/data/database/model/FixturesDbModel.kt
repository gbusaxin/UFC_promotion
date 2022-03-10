package com.example.ufcpromotion.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_fixtures")
class FixturesDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val enemy1: String,
    val enemy1image: String,
    val enemy2: String,
    val enemy2image: String,
    val whoWin: Int,
    val number: String,
    val weight: String
)
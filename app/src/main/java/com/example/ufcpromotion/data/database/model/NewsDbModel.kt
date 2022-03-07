package com.example.ufcpromotion.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_news")
data class NewsDbModel(
    val imageNews: String,
    @PrimaryKey(autoGenerate = false)
    val titleNews: String,
    val shortNews: String,
    val dateNews: String,
    val bodyNews: String
)
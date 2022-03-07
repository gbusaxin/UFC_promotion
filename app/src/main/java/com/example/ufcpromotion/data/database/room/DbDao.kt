package com.example.ufcpromotion.data.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ufcpromotion.data.database.model.NewsDbModel

@Dao
interface DbDao {

    @Query("SELECT * FROM table_news")
    fun getNewsData(): LiveData<List<NewsDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsData(listNews:List<NewsDbModel>)

}
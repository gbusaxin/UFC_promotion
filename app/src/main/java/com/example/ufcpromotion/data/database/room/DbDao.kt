package com.example.ufcpromotion.data.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ufcpromotion.data.database.model.FixturesDbModel
import com.example.ufcpromotion.data.database.model.NewsDbModel
import com.example.ufcpromotion.data.database.model.P4PDbModel
import com.example.ufcpromotion.data.database.model.ResultDbModel
import com.example.ufcpromotion.domain.pojo.NewsItem

@Dao
interface DbDao {

    // News Data operations
    @Query("SELECT * FROM table_news")
    fun getNewsData(): LiveData<List<NewsDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsData(list: List<NewsDbModel>)

    @Query("SELECT * FROM table_news WHERE titleNews ==:news")
    fun getSelectedNewsData(news: String): LiveData<NewsDbModel>

    // Fixtures Data operations
    @Query("SELECT * FROM table_fixtures")
    fun getFixturesData(): LiveData<List<FixturesDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFixturesData(list: List<FixturesDbModel>)

    @Query("DELETE FROM table_fixtures")
    fun deleteAllFixtures()

    // Results Data operations
    @Query("SELECT * FROM table_results")
    fun getResultsData(): LiveData<List<ResultDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResultsData(list: List<ResultDbModel>)

    @Query("DELETE FROM table_results")
    fun deleteAllResults()

    // P4P Data operations
    @Query("SELECT * FROM table_p4p")
    fun getP4PData(): LiveData<List<P4PDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertP4PData(list: List<P4PDbModel>)

}
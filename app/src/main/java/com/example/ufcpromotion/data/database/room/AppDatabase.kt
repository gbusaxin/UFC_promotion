package com.example.ufcpromotion.data.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ufcpromotion.data.database.model.FixturesDbModel
import com.example.ufcpromotion.data.database.model.NewsDbModel
import com.example.ufcpromotion.data.database.model.P4PDbModel
import com.example.ufcpromotion.data.database.model.ResultDbModel

@Database(
    entities = [
        NewsDbModel::class,
        FixturesDbModel::class,
        ResultDbModel::class,
        P4PDbModel::class
    ], version = 4, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "ufc.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                return instance
            }
        }

    }

    abstract fun dbDao(): DbDao

}
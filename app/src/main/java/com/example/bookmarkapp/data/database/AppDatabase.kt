package com.example.bookmarkapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookmarkapp.data.database.dao.BookMarkDao
import com.example.bookmarkapp.data.database.entity.BookMark

@Database(entities = [BookMark::class], version = 5)
abstract class AppDatabase: RoomDatabase() {
    abstract fun bookMarkDao(): BookMarkDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: run {
                    Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "book_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }.also { INSTANCE = it }
            }
    }
}
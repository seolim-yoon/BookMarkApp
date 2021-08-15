package com.example.bookmarkapp.di.database

import android.content.Context
import com.example.bookmarkapp.data.database.AppDatabase
import com.example.bookmarkapp.data.database.dao.BookMarkDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideBookMarkDao(appDatabase: AppDatabase): BookMarkDao = appDatabase.bookMarkDao()

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase = AppDatabase.getInstance(context)

}
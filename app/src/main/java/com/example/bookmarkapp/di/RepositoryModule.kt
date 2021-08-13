package com.example.bookmarkapp.di

import com.example.bookmarkapp.data.repository.bookmark.BookMarkRepository
import com.example.bookmarkapp.data.repository.bookmark.BookMarkRepositoryImpl
import com.example.bookmarkapp.data.repository.detail.DetailRepository
import com.example.bookmarkapp.data.repository.detail.DetailRepositoryImpl
import com.example.bookmarkapp.data.repository.home.HomeRepository
import com.example.bookmarkapp.data.repository.home.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl) : HomeRepository

    @Binds
    @Singleton
    fun bindBookMarkRepository(bookMarkRepositoryImpl: BookMarkRepositoryImpl) : BookMarkRepository

    @Binds
    @Singleton
    fun bindDetailRepository(detailRepositoryImpl: DetailRepositoryImpl) : DetailRepository

    // repository 추가될 때 마다 여기에 추가해줌
}
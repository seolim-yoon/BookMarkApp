package com.example.bookmarkapp.data.repository.bookmark

import com.example.bookmarkapp.data.database.entity.BookMark
import io.reactivex.Completable
import io.reactivex.Single

interface BookMarkRepository {
    fun getBookMarkByTimeAsc(): Single<List<BookMark>>

    fun getBookMarkByTimeDesc(): Single<List<BookMark>>

    fun getBookMarkByRateAsc(): Single<List<BookMark>>

    fun getBookMarkByRateDesc(): Single<List<BookMark>>

    fun updateBookMark(bookMark: BookMark): Completable
}
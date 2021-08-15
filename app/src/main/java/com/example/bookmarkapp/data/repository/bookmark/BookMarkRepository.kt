package com.example.bookmarkapp.data.repository.bookmark

import com.example.bookmarkapp.data.database.entity.BookMark
import io.reactivex.Completable
import io.reactivex.Single

interface BookMarkRepository {
    fun insertBookMark(bookMark: BookMark): Completable

    fun deleteBookMark(bookMark: BookMark): Completable

    fun getBookMarkByTimeAsc(): Single<List<BookMark>>

    fun getBookMarkByTimeDesc(): Single<List<BookMark>>

    fun getBookMarkByRateAsc(): Single<List<BookMark>>

    fun getBookMarkByRateDesc(): Single<List<BookMark>>

    fun getBookMarkState(id: Int): Single<Boolean>
}
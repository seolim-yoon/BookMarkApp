package com.example.bookmarkapp.data.repository.home

import androidx.paging.PagingSource
import com.example.bookmarkapp.data.database.entity.BookMark
import com.example.bookmarkapp.data.remote.response.ProductResult
import io.reactivex.Completable
import io.reactivex.Single

interface HomeRepository {
    fun getProductList(page: Int): Single<ProductResult>

    fun getAllList(): PagingSource<Int, BookMark>

    fun insertBookMark(bookMarks: List<BookMark>): Completable
}
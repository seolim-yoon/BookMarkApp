package com.example.bookmarkapp.data.repository.home

import androidx.paging.PagingSource
import com.example.bookmarkapp.data.database.dao.BookMarkDao
import com.example.bookmarkapp.data.database.entity.BookMark
import com.example.bookmarkapp.data.remote.response.ProductResult
import com.example.bookmarkapp.data.remote.service.RetrofitService
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService,
    private val bookMarkDao: BookMarkDao
) : HomeRepository {
    override fun getProductList(page: Int): Single<ProductResult> = retrofitService.getProductList(page)

    override fun getAllList(): PagingSource<Int, BookMark> = bookMarkDao.getAllList()

    override fun insertBookMark(bookMarks: List<BookMark>): Completable = bookMarkDao.insertBookMark(bookMarks)
}
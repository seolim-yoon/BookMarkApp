package com.example.bookmarkapp.data.repository.bookmark

import com.example.bookmarkapp.data.database.dao.BookMarkDao
import com.example.bookmarkapp.data.database.entity.BookMark
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(private val bookMarkDao: BookMarkDao): BookMarkRepository {
    override fun getBookMarkByTimeAsc(): Single<List<BookMark>> = bookMarkDao.getBookMarkByTimeAsc(true)

    override fun getBookMarkByTimeDesc(): Single<List<BookMark>> = bookMarkDao.getBookMarkByTimeDesc(true)

    override fun getBookMarkByRateAsc(): Single<List<BookMark>> = bookMarkDao.getBookMarkByRateAsc(true)

    override fun getBookMarkByRateDesc(): Single<List<BookMark>> = bookMarkDao.getBookMarkByRateDesc(true)

    override fun updateBookMark(bookMark: BookMark): Completable = bookMarkDao.updateBookMark(bookMark)
}
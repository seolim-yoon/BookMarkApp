package com.example.bookmarkapp.data.repository.bookmark

import com.example.bookmarkapp.data.database.dao.BookMarkDao
import com.example.bookmarkapp.data.database.entity.BookMark
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(private val bookMarkDao: BookMarkDao): BookMarkRepository {
    override fun insertBookMark(bookMark: BookMark): Completable = bookMarkDao.insertBookMark(bookMark)

    override fun deleteBookMark(bookMark: BookMark): Completable = bookMarkDao.deleteBookMark(bookMark)

    override fun getBookMarkByTimeAsc(): Single<List<BookMark>> = bookMarkDao.getBookMarkByTimeAsc()

    override fun getBookMarkByTimeDesc(): Single<List<BookMark>> = bookMarkDao.getBookMarkByTimeDesc()

    override fun getBookMarkByRateAsc(): Single<List<BookMark>> = bookMarkDao.getBookMarkByRateAsc()

    override fun getBookMarkByRateDesc(): Single<List<BookMark>> = bookMarkDao.getBookMarkByRateDesc()

    override fun getBookMarkState(id: Int): Single<Boolean> = bookMarkDao.getBookMarkState(id)
}
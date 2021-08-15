package com.example.bookmarkapp.data.database.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.bookmarkapp.data.database.entity.BookMark
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface BookMarkDao {

    @Query("SELECT * FROM BookMark")
    fun getAllList(): PagingSource<Int, BookMark>

    @Query("SELECT * FROM BookMark WHERE isBookMark LIKE :isBookMark ORDER BY time ASC")
    fun getBookMarkByTimeAsc(isBookMark: Boolean): Single<List<BookMark>>

    @Query("SELECT * FROM BookMark WHERE isBookMark LIKE :isBookMark ORDER BY time DESC")
    fun getBookMarkByTimeDesc(isBookMark: Boolean): Single<List<BookMark>>

    @Query("SELECT * FROM BookMark WHERE isBookMark LIKE :isBookMark ORDER BY rate ASC")
    fun getBookMarkByRateAsc(isBookMark: Boolean): Single<List<BookMark>>

    @Query("SELECT * FROM BookMark WHERE isBookMark LIKE :isBookMark ORDER BY rate DESC")
    fun getBookMarkByRateDesc(isBookMark: Boolean): Single<List<BookMark>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBookMark(bookMarks: List<BookMark>): Completable

    @Update
    fun updateBookMark(bookMark: BookMark): Completable

}
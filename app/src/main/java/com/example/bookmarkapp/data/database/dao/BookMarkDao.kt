package com.example.bookmarkapp.data.database.dao

import androidx.room.*
import com.example.bookmarkapp.data.database.entity.BookMark
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface BookMarkDao {

    @Query("SELECT * FROM BookMark ORDER BY time ASC")
    fun getBookMarkByTimeAsc(): Single<List<BookMark>>

    @Query("SELECT * FROM BookMark ORDER BY time DESC")
    fun getBookMarkByTimeDesc(): Single<List<BookMark>>

    @Query("SELECT * FROM BookMark ORDER BY rate ASC")
    fun getBookMarkByRateAsc(): Single<List<BookMark>>

    @Query("SELECT * FROM BookMark ORDER BY rate DESC")
    fun getBookMarkByRateDesc(): Single<List<BookMark>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookMark(bookMark: BookMark): Completable

    @Delete
    fun deleteBookMark(bookMark: BookMark): Completable

    @Query("SELECT isBookMark FROM BookMark WHERE id LIKE :id")
    fun getBookMarkState(id: Int): Single<Boolean>
}
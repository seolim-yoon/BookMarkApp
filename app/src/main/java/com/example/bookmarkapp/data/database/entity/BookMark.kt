package com.example.bookmarkapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "BookMark")
data class BookMark(
    @PrimaryKey val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val rate: Double,
    val imgUrl: String,
    val subject: String,
    val price: Int
): Serializable {
    var isBookMark: Boolean = false
    var time: String = ""
}

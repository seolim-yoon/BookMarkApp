package com.example.bookmarkapp.data.remote.response

import com.example.bookmarkapp.data.database.entity.BookMark
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("product")
    val product: List<Product>,
    @SerializedName("totalCount")
    val totalCount: Int
)

fun Data.transformBookMark(): List<BookMark> =
    this.product.map { product ->
        BookMark(
            product.id,
            product.thumbnail,
            product.name,
            product.rate,
            product.description.imagePath,
            product.description.subject,
            product.description.price
        )
    }

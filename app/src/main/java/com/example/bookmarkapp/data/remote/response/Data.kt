package com.example.bookmarkapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("product")
    val product: List<Product>,
    @SerializedName("totalCount")
    val totalCount: Int
)
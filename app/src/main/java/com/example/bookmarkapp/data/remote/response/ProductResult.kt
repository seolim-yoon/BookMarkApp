package com.example.bookmarkapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProductResult(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: Data,
    @SerializedName("msg")
    val msg: String
)
package com.example.bookmarkapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("imagePath")
    val imagePath: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("subject")
    val subject: String
)
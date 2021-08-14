package com.example.bookmarkapp.data.remote.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Product(
    @SerializedName("description")
    val description: Description,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("thumbnail")
    val thumbnail: String
): Serializable
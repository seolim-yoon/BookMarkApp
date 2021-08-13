package com.example.bookmarkapp.data.remote.service

import com.example.bookmarkapp.data.remote.response.ProductResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("App/json/{page}.json")
    fun getProductList(
        @Path("page") page: String
    ): Single<ProductResult>

}
package com.example.bookmarkapp.data.repository.home

import com.example.bookmarkapp.data.remote.response.ProductResult
import com.example.bookmarkapp.data.remote.service.RetrofitService
import io.reactivex.Single
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val retrofitService: RetrofitService): HomeRepository {
    override fun getProductList(page: Int): Single<ProductResult> = retrofitService.getProductList(page)
}
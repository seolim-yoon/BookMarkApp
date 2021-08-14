package com.example.bookmarkapp.data.repository.home

import com.example.bookmarkapp.data.remote.response.ProductResult
import io.reactivex.Single

interface HomeRepository {
    fun getProductList(page: Int): Single<ProductResult>
}
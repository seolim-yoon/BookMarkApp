package com.example.bookmarkapp.ui.fragment.home

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.example.bookmarkapp.data.remote.response.Product
import com.example.bookmarkapp.data.repository.home.HomeRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePagingSource @Inject constructor(private val homeRepository: HomeRepository) : RxPagingSource<Int, Product>() {
    // 초기 key값 또는 데이터 로드 중단 후 재로드 시 이전 position에서 중단된 key값을 가져오는 로직 추가
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? = null

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Product>> {
        val nextPage: Int = params.key ?: 1
        return homeRepository.getProductList(nextPage)
            .subscribeOn(Schedulers.io())
            .map<LoadResult<Int, Product>> { result ->
                LoadResult.Page(
                    data = result.data.product,
                    prevKey = null,
                    nextKey = if(nextPage == result.data.product.size) null else nextPage + 1
                )
            }
    }
}
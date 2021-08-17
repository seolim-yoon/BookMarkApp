package com.example.bookmarkapp.ui.fragment.home

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.example.bookmarkapp.data.database.entity.BookMark
import com.example.bookmarkapp.data.remote.response.transformBookMark
import com.example.bookmarkapp.data.repository.home.HomeRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/*
    서버에서 가져온 데이터로 Paging 처리
    -> Room DB 데이터로 처리하도록 변경하여 사용하지 않음
*/

class HomePagingSource @Inject constructor(private val homeRepository: HomeRepository) : RxPagingSource<Int, BookMark>() {
    // 초기 key값 또는 데이터 로드 중단 후 재로드 시 이전 position에서 중단된 key값을 가져오는 로직 추가
    override fun getRefreshKey(state: PagingState<Int, BookMark>): Int? = null

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, BookMark>> {
        val nextPage: Int = params.key ?: 1
        return homeRepository.getProductList(nextPage)
            .subscribeOn(Schedulers.io())
            .map<LoadResult<Int, BookMark>> { result ->
                LoadResult.Page(
                    data = result.data.transformBookMark(),
                    prevKey = null,
                    nextKey = if(nextPage == result.data.product.size) null else nextPage + 1
                )
            }
    }
}
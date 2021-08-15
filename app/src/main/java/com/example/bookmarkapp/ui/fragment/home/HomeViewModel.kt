package com.example.bookmarkapp.ui.fragment.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.bookmarkapp.base.BaseViewModel
import com.example.bookmarkapp.data.database.entity.BookMark
import com.example.bookmarkapp.data.remote.response.transformBookMark
import com.example.bookmarkapp.data.repository.home.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : BaseViewModel() {
    val homePager = Pager(PagingConfig(pageSize = PER_PAGE)) {
        homeRepository.getAllList()
    }.flow.cachedIn(viewModelScope)

    companion object {
        const val PER_PAGE: Int = 20
    }

    init {
        getBookMarkResult(1)
        getBookMarkResult(2)
        getBookMarkResult(3)
    }

    private fun getBookMarkResult(page: Int) = addDisposable(homeRepository.getProductList(page)
        .subscribeOn(Schedulers.io())
        .subscribe({ list ->
            insertBookMark(list.data.transformBookMark())
        }, { e ->
            Log.e("seolim", "error : " + e.message)
        })
    )

    private fun insertBookMark(bookMarks: List<BookMark>) = addDisposable(homeRepository.insertBookMark(bookMarks)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {

        }
    )
}
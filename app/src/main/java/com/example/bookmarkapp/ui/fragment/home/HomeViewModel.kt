package com.example.bookmarkapp.ui.fragment.home

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.bookmarkapp.base.BaseViewModel
import com.example.bookmarkapp.data.repository.home.HomeRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : BaseViewModel() {
    val homePager = Pager(PagingConfig(pageSize = PER_PAGE)) {
        HomePagingSource(homeRepository)
    }.flow.cachedIn(viewModelScope)

    companion object {
        const val PER_PAGE: Int = 20
    }
}
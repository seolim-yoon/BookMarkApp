package com.example.bookmarkapp.ui.fragment.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    // Paging 사용하여 Room에 저장된 리스트 불러옴
    val homePager = Pager(PagingConfig(pageSize = PER_PAGE)) {
        homeRepository.getAllList()
    }.flow.cachedIn(viewModelScope)

    companion object {
        const val PER_PAGE: Int = 20
    }

    private var _updateBookMark = MutableLiveData<BookMark>()
    val updateBookMark: LiveData<BookMark>
        get() = _updateBookMark

    init {
        getBookMarkResult(1)
        getBookMarkResult(2)
        getBookMarkResult(3)
    }

    // API를 통해 가져온 데이터를 BookMark 데이터로 변환하여 Room DB에 넣음
    private fun getBookMarkResult(page: Int) = addDisposable(homeRepository.getProductList(page)
        .subscribeOn(Schedulers.io())
        .subscribe({ list ->
            getCheckBookMarkId(list.data.transformBookMark())
        }, { e ->
            Log.e("seolim", "error : " + e.message)
        })
    )

    private fun getCheckBookMarkId(list: List<BookMark>) = addDisposable(homeRepository.getCheckBookMark()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { checkList ->
            insertBookMark(
                list,
                checkList.map { it.id to it.time }.toMap()
            )
        }
    )

    private fun insertBookMark(bookMarks: List<BookMark>, bookMarkMap: Map<Int, String>) = addDisposable(homeRepository.insertBookMark(bookMarks)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
            bookMarks.forEach { bookMarks ->
                if(bookMarkMap.containsKey(bookMarks.id)) {
                    bookMarks.isBookMark = true
                    bookMarks.time = bookMarkMap[bookMarks.id] ?: ""
                    _updateBookMark.value = bookMarks
                }
            }
        }
    )
}
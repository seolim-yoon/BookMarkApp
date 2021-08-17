package com.example.bookmarkapp.ui.fragment.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bookmarkapp.base.BaseViewModel
import com.example.bookmarkapp.data.database.entity.BookMark
import com.example.bookmarkapp.data.repository.bookmark.BookMarkRepository
import com.example.bookmarkapp.ui.model.Sort
import com.example.bookmarkapp.util.FormatUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class BookMarkViewModel @Inject constructor(private val bookMarkRepository: BookMarkRepository) : BaseViewModel() {
    private var _bookMarkList = MutableLiveData<List<BookMark>>()
    val bookMarkList: LiveData<List<BookMark>>
        get() = _bookMarkList

    private var _sortList = MutableLiveData<List<Sort>>()
    val sortList: LiveData<List<Sort>>
        get() = _sortList

    private var _selectSortType = MutableLiveData<Sort>()
    val selectSortType: LiveData<Sort>
        get() = _selectSortType

    init {
        _sortList.value = listOf(
            Sort(0, "최근 등록 순", true),
            Sort(1, "오래된 순", false),
            Sort(2, "평점 높은 순", false),
            Sort(3, "평점 낮은 순", false)
        )
        _selectSortType.value = _sortList.value!![0]
        updateBookMarkList()
    }

    fun updateBookMarkList() {
        when (_selectSortType.value?.id) {
            0 -> getBookMarkByTimeDesc()
            1 -> getBookMarkByTimeAsc()
            2 -> getBookMarkByRateDesc()
            3 -> getBookMarkByRateAsc()
        }
    }

    // 하트 표시 누를 때 마다 isBookMark 상태 DB에 업데이트
    fun updateBookMark(bookMark: BookMark) = addDisposable(bookMarkRepository.updateBookMark(bookMark)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
            updateBookMarkList()
        }
    )

    // DetailFragment에서 하트 표시 클릭 시 isBookMark 상태 DB에 업데이트
    fun clickBookMark(bookMark: BookMark) {
        bookMark.isBookMark = !bookMark.isBookMark

        if(bookMark.isBookMark)
            bookMark.time = FormatUtils.dateFormat.format(Date(System.currentTimeMillis()))

        updateBookMark(bookMark)
    }

    private fun getBookMarkByTimeAsc() = addDisposable(bookMarkRepository.getBookMarkByTimeAsc()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ bookMarks ->
            _bookMarkList.value = bookMarks
        }, {

        })
    )

    private fun getBookMarkByTimeDesc() = addDisposable(bookMarkRepository.getBookMarkByTimeDesc()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ bookMarks ->
            _bookMarkList.value = bookMarks
        }, {

        })
    )

    private fun getBookMarkByRateAsc() = addDisposable(bookMarkRepository.getBookMarkByRateAsc()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ bookMarks ->
            _bookMarkList.value = bookMarks
        }, {

        })
    )

    private fun getBookMarkByRateDesc() = addDisposable(bookMarkRepository.getBookMarkByRateDesc()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ bookMarks ->
            _bookMarkList.value = bookMarks
        }, {

        })
    )

    // 정렬 타입 선택 시
    fun setSelectSortType(sort: Sort) {
        _selectSortType.value = sort
    }
}
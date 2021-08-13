package com.example.bookmarkapp.ui.fragment.bookmark

import com.example.bookmarkapp.base.BaseViewModel
import com.example.bookmarkapp.data.repository.bookmark.BookMarkRepository
import javax.inject.Inject

class BookMarkViewModel @Inject constructor(private val bookMarkRepository: BookMarkRepository) : BaseViewModel() {

}
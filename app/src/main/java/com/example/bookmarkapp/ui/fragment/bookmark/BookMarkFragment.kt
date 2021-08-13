package com.example.bookmarkapp.ui.fragment.bookmark

import com.example.bookmarkapp.R
import com.example.bookmarkapp.base.BaseFragment
import com.example.bookmarkapp.databinding.FragmentBookmarkBinding
import kotlin.reflect.KClass

class BookMarkFragment: BaseFragment<FragmentBookmarkBinding, BookMarkViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_bookmark
    override val viewModelClass: KClass<BookMarkViewModel>
        get() = BookMarkViewModel::class

    override fun initView() {

    }
}
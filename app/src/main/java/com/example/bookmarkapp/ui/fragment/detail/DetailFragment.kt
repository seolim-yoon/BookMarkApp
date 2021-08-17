package com.example.bookmarkapp.ui.fragment.detail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bookmarkapp.R
import com.example.bookmarkapp.base.BaseFragment
import com.example.bookmarkapp.databinding.FragmentDetailBinding
import com.example.bookmarkapp.ui.fragment.bookmark.BookMarkViewModel
import kotlin.reflect.KClass

class DetailFragment: BaseFragment<FragmentDetailBinding, BookMarkViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_detail
    override val viewModelClass: KClass<BookMarkViewModel>
        get() = BookMarkViewModel::class

    private val safeArgs: DetailFragmentArgs by navArgs()

    override fun initView() {
        with(viewDataBinding) {
            bookmark = safeArgs.bookmark

            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }

            ivBookmark.setOnClickListener {
                viewModel.clickBookMark(safeArgs.bookmark)
                invalidateAll()
            }
        }
    }
}
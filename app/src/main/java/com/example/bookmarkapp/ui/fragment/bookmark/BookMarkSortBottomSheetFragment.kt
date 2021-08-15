package com.example.bookmarkapp.ui.fragment.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.bookmarkapp.R
import com.example.bookmarkapp.databinding.LayoutBookmarkSortBottomSheetBinding
import com.example.bookmarkapp.ui.adapter.SortListAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookMarkSortBottomSheetFragment() : BottomSheetDialogFragment() {
    private lateinit var viewDataBinding: LayoutBookmarkSortBottomSheetBinding

    private val bookMarkViewModel by activityViewModels<BookMarkViewModel>()

    private val sortAdapter by lazy {
        SortListAdapter(bookMarkViewModel.selectSortType.value?.id ?: 0) { sort ->
            bookMarkViewModel.setSelectSortType(sort)
            this.dismiss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.layout_bookmark_sort_bottom_sheet, container, false)
        viewDataBinding.lifecycleOwner = this
        initView()
        return viewDataBinding.root
    }

    private fun initView() {
        with(viewDataBinding.rvBookmarkSort) {
            adapter = sortAdapter
        }

        bookMarkViewModel.sortList.observe(viewLifecycleOwner, { sorts ->
            sortAdapter.submitList(sorts.orEmpty())
        })
    }

    override fun getTheme(): Int = R.style.BottomSheetDialog
}
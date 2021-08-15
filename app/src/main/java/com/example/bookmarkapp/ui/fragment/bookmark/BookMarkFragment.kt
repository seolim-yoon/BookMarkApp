package com.example.bookmarkapp.ui.fragment.bookmark

import com.example.bookmarkapp.R
import com.example.bookmarkapp.base.BaseFragment
import com.example.bookmarkapp.databinding.FragmentBookmarkBinding
import com.example.bookmarkapp.ui.adapter.BookMarkListAdapter
import com.example.bookmarkapp.util.BookMarkState
import kotlin.reflect.KClass

class BookMarkFragment: BaseFragment<FragmentBookmarkBinding, BookMarkViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_bookmark
    override val viewModelClass: KClass<BookMarkViewModel>
        get() = BookMarkViewModel::class

    private val bookMarkAdapter by lazy {
        BookMarkListAdapter {

        }
    }

    override fun initView() {
        with(viewDataBinding.rvBookMarkProduct) {
            adapter = bookMarkAdapter
        }

        viewDataBinding.btnSort.setOnClickListener {
            BookMarkSortBottomSheetFragment().show(requireActivity().supportFragmentManager, "BookMarkSortBottomSheetFragment")
        }

        with(viewModel) {
            updateBookMark.observe(viewLifecycleOwner, { state ->
                if(state == BookMarkState.INSERT || state == BookMarkState.DELETE) {
                    getBookMarkByTimeDesc()
                    setStateNone()
                }
            })

            bookMarkList.observe(viewLifecycleOwner, { bookMarks ->
                bookMarkAdapter.submitList(bookMarks.orEmpty().toMutableList())
            })

            selectSortType.observe(viewLifecycleOwner, { sort ->
                viewDataBinding.tvSort.text = sort.title
            })
        }
    }
}
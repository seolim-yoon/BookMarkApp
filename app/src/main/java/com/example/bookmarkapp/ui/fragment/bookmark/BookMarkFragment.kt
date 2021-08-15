package com.example.bookmarkapp.ui.fragment.bookmark

import androidx.navigation.fragment.findNavController
import com.example.bookmarkapp.R
import com.example.bookmarkapp.base.BaseFragment
import com.example.bookmarkapp.databinding.FragmentBookmarkBinding
import com.example.bookmarkapp.ui.adapter.BookMarkListAdapter
import kotlin.reflect.KClass

class BookMarkFragment: BaseFragment<FragmentBookmarkBinding, BookMarkViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_bookmark
    override val viewModelClass: KClass<BookMarkViewModel>
        get() = BookMarkViewModel::class

    private val bookMarkAdapter by lazy {
        BookMarkListAdapter({ bookMark ->
            findNavController().navigate(BookMarkFragmentDirections.actionBookMarkFragmentToDetailFragment(bookMark))
        }, { bookMark ->
            // bookmark click
            viewModel.updateBookMark(bookMark)
            viewModel.updateBookMarkList()
        })
    }

    override fun initView() {
        with(viewDataBinding.rvBookMarkProduct) {
            adapter = bookMarkAdapter
        }

        viewDataBinding.btnSort.setOnClickListener {
            BookMarkSortBottomSheetFragment().show(requireActivity().supportFragmentManager, "BookMarkSortBottomSheetFragment")
        }

        with(viewModel) {
            bookMarkList.observe(viewLifecycleOwner, { bookMarks ->
                bookMarkAdapter.submitList(bookMarks.orEmpty().toMutableList())
            })

            selectSortType.observe(viewLifecycleOwner, { sort ->
                viewDataBinding.sort = sort
                updateBookMarkList()
            })
        }
    }
}
package com.example.bookmarkapp.ui.fragment.home

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.bookmarkapp.R
import com.example.bookmarkapp.base.BaseFragment
import com.example.bookmarkapp.databinding.FragmentHomeBinding
import com.example.bookmarkapp.ui.adapter.ProductPagingAdapter
import com.example.bookmarkapp.ui.fragment.bookmark.BookMarkViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_home
    override val viewModelClass: KClass<HomeViewModel>
        get() = HomeViewModel::class

    private val bookMarkViewModel by lazy {
        ViewModelProvider(requireActivity().viewModelStore, viewModelFactory).get(BookMarkViewModel::class.java)
    }

    private val productAdapter by lazy {
        ProductPagingAdapter ({ bookMark ->
            // item click
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(bookMark))
        }, { bookMark ->
            // bookmark click
            when(bookMark.isBookMark) {
                true -> { bookMarkViewModel.insertBookMark(bookMark) }
                false -> { bookMarkViewModel.deleteBookMark(bookMark) }
            }
        })
    }

    override fun initView() {
        with(viewDataBinding.rvProduct) {
            adapter = productAdapter
        }

        // swipe할 때 마다 리스트 새로고침
        with(viewDataBinding.slSwipeRefresh) {
            setOnRefreshListener {
                productAdapter.refresh()
                isRefreshing = false
            }
        }

        lifecycleScope.launch {
            viewModel.homePager.collectLatest { pagingData ->
                productAdapter.submitData(pagingData)
            }
        }
    }
}
package com.example.bookmarkapp.ui.fragment.detail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bookmarkapp.R
import com.example.bookmarkapp.base.BaseFragment
import com.example.bookmarkapp.databinding.FragmentDetailBinding
import kotlin.reflect.KClass

class DetailFragment: BaseFragment<FragmentDetailBinding, DetailViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_detail
    override val viewModelClass: KClass<DetailViewModel>
        get() = DetailViewModel::class

    private val safeArgs: DetailFragmentArgs by navArgs()

    override fun initView() {
        viewDataBinding.product = safeArgs.product
        viewDataBinding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
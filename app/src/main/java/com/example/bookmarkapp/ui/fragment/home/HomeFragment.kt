package com.example.bookmarkapp.ui.fragment.home

import com.example.bookmarkapp.R
import com.example.bookmarkapp.base.BaseFragment
import com.example.bookmarkapp.databinding.FragmentHomeBinding
import kotlin.reflect.KClass

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_home
    override val viewModelClass: KClass<HomeViewModel>
        get() = HomeViewModel::class

    override fun initView() {


    }
}
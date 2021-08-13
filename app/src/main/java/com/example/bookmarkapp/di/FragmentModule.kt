package com.example.bookmarkapp.di

import com.example.bookmarkapp.di.scope.FragmentScope
import com.example.bookmarkapp.ui.fragment.bookmark.BookMarkFragment
import com.example.bookmarkapp.ui.fragment.bookmark.BookMarkFragmentModule
import com.example.bookmarkapp.ui.fragment.detail.DetailFragment
import com.example.bookmarkapp.ui.fragment.detail.DetailFragmentModule
import com.example.bookmarkapp.ui.fragment.home.HomeFragment
import com.example.bookmarkapp.ui.fragment.home.HomeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule{
    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    fun bindHomeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [BookMarkFragmentModule::class])
    fun bindBookMarkFragment(): BookMarkFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    fun bindDetailFragment(): DetailFragment

    // fragment 추가할 때 fragmentmodule도 세트로 추가하고, 추가될 때 마다 여기에 fragment와 module 추가해줌
}
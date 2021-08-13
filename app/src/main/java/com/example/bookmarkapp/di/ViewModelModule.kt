package com.example.bookmarkapp.di

import androidx.lifecycle.ViewModelProvider
import com.example.bookmarkapp.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
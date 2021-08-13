package com.example.bookmarkapp.ui.fragment.detail

import androidx.lifecycle.ViewModel
import com.example.bookmarkapp.di.ViewModelKey
import com.example.bookmarkapp.di.scope.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailFragmentModule {
    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class) // MultiBinding. 반환되는 타입 (Map의 Key)
    internal abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel
}
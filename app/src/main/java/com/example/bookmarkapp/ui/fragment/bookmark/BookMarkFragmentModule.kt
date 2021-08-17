package com.example.bookmarkapp.ui.fragment.bookmark

import androidx.lifecycle.ViewModel
import com.example.bookmarkapp.di.ViewModelKey
import com.example.bookmarkapp.di.scope.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BookMarkFragmentModule {
    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(BookMarkViewModel::class) // MultiBinding. 반환되는 타입 (Map의 Key)
    internal abstract fun bindBookMarkViewModel(bookMarkViewModel: BookMarkViewModel): ViewModel
}
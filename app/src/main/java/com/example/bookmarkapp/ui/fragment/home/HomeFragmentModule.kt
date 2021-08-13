package com.example.bookmarkapp.ui.fragment.home

import androidx.lifecycle.ViewModel
import com.example.bookmarkapp.di.ViewModelKey
import com.example.bookmarkapp.di.scope.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeFragmentModule {
    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class) // MultiBinding. 반환되는 타입 (Map의 Key)
    internal abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    // MainFragment에서 Inject 하는 변수가 생길 때 마다 여기에 선언 (ViewModel은 ViewModelFactory를 Inject 하기 때문에 무조건 추가)
}
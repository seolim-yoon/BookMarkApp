package com.example.bookmarkapp.ui.activity

import androidx.lifecycle.ViewModel
import com.example.bookmarkapp.di.ViewModelKey
import com.example.bookmarkapp.di.scope.ActivityScope
import com.example.bookmarkapp.ui.fragment.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {
    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class) // MultiBinding. 반환되는 타입 (Map의 Key)
    internal abstract fun bindMainViewModel(homeViewModel: HomeViewModel): ViewModel

    // MainActivity에서 Inject 하는 변수가 생길 때 마다 여기에 선언 (ViewModel은 ViewModelFactory를 Inject 하기 때문에 무조건 추가)
}
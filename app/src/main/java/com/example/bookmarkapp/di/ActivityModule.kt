package com.example.bookmarkapp.di

import com.example.bookmarkapp.di.scope.ActivityScope
import com.example.bookmarkapp.ui.activity.MainActivity
import com.example.bookmarkapp.ui.activity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun bindMainActivity(): MainActivity

    // activity 추가할 때 activitymodule도 세트로 추가하고, 추가될 때 마다 여기에 activity와 module 추가해줌

}
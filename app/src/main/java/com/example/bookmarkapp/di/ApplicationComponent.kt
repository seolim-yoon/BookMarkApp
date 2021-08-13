package com.example.bookmarkapp.di

import android.app.Application
import com.example.bookmarkapp.BookMarkApplication
import com.example.bookmarkapp.di.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ContextModule::class,
        ActivityModule::class,
        FragmentModule::class,
        RepositoryModule::class,
        NetworkModule::class,
        ViewModelModule::class,
    ]
)

interface ApplicationComponent : AndroidInjector<BookMarkApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
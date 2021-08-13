package com.example.bookmarkapp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ContextModule {
    @Provides
    @Singleton
    fun provideContext(application: Application) : Context = application
}
package com.example.bookmarkapp.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bookmarkapp.base.BaseViewModel
import com.example.bookmarkapp.data.repository.home.HomeRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : BaseViewModel() {
    private var _liveData = MutableLiveData<Any>()
    val liveData: LiveData<Any>
        get() = _liveData
}
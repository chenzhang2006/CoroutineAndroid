package com.chenzhang.coroutine.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chenzhang.coroutine.data.RoomRepository
import java.lang.IllegalArgumentException

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when (modelClass) {
            MainViewModel::class.java -> MainViewModel(RoomRepository()) as T
            else -> throw IllegalArgumentException("viewModel class type is illegal")
        }
}
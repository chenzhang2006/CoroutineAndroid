package com.chenzhang.coroutine.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chenzhang.coroutine.data.Room

class MainViewModel: ViewModel() {

    private val rooms: MutableLiveData<List<Room>> by lazy {
        MutableLiveData<List<Room>>().apply {
            postValue(listOf(Room("Dog", 4), Room("Cat", 6)))
        }
    }

    fun getRooms(): LiveData<List<Room>> = rooms

}
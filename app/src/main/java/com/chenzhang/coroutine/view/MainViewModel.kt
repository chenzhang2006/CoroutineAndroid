package com.chenzhang.coroutine.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chenzhang.coroutine.data.Room
import com.chenzhang.coroutine.data.RoomRepository
import kotlinx.coroutines.*


/**
 * CoroutineScope: https://github.com/Kotlin/kotlinx.coroutines/blob/master/ui/coroutines-guide-ui.md
 */
class MainViewModel(private val roomRepository: RoomRepository) : ViewModel(),
    CoroutineScope by MainScope() {

    private val roomLiveData: MutableLiveData<List<Room>> by lazy {
        MutableLiveData<List<Room>>().apply {
            postValue(listOf())
        }.also {
            loadRooms()
        }
    }

    fun getRooms(): LiveData<List<Room>> = roomLiveData

    private fun loadRooms() {
        launch(Dispatchers.IO) {
            val roomList = roomRepository.fetchRooms()
            withContext(Dispatchers.Main) {
                roomLiveData.postValue(roomList)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        cancel() //coroutineScope
    }
}
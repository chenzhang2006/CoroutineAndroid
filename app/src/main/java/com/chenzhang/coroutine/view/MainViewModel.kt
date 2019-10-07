package com.chenzhang.coroutine.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chenzhang.coroutine.data.Repo
import com.chenzhang.coroutine.data.Room
import com.chenzhang.coroutine.data.RoomRepository
import kotlinx.coroutines.*


/**
 * CoroutineScope: https://github.com/Kotlin/kotlinx.coroutines/blob/master/ui/coroutines-guide-ui.md
 */

//TODO unit test
class MainViewModel(private val roomRepository: RoomRepository) : ViewModel(),
    CoroutineScope by MainScope() {

    private val roomLiveData: MutableLiveData<List<Repo>> by lazy {
        MutableLiveData<List<Repo>>().apply {
            postValue(listOf())
        }.also {
            loadRooms()
        }
    }

    fun getRooms(): LiveData<List<Repo>> = roomLiveData

    private fun loadRooms() {
        launch(Dispatchers.IO) {
            //TODO use room fetch for another view on screen
//            val roomList = roomRepository.fetchRooms()
//            withContext(Dispatchers.Main) {
//                roomLiveData.postValue(roomList)
//            }

            val repos = roomRepository.fetchRepos()
            withContext(Dispatchers.Main) {
                roomLiveData.postValue(repos)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        cancel() //coroutineScope
    }
}
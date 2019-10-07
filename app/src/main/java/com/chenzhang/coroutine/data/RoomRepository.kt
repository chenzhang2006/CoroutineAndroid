package com.chenzhang.coroutine.data

import android.util.Log
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//TODO unit test
class RoomRepository {

    //TODO Dependency Injection
    private val githubService: GitHubService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        githubService = retrofit.create(GitHubService::class.java)
    }

    suspend fun fetchRooms(): List<Room> {
        delay(2000)
        return listOf(Room("Dog", 4), Room("Cat", 6))
    }

    suspend fun fetchRepos(): List<Repo> { //TODO return Success/Failure sealed class type
        val response = githubService.getRepos()
        Log.d(TAG, "Response Headers: ${response.headers()}")
        return response.body() ?: emptyList()
    }

    companion object {
        const val TAG = "Repository"
    }
}
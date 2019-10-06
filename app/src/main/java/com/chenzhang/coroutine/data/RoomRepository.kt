package com.chenzhang.coroutine.data

import kotlinx.coroutines.delay

class RoomRepository {
    suspend fun fetchRooms(): List<Room>{
        delay(2000)
        return listOf(Room("Dog", 4), Room("Cat", 6))
    }
}
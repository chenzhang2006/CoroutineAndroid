package com.chenzhang.coroutine.data

import retrofit2.Response
import retrofit2.http.GET

/**
 * https://android.jlelse.eu/kotlin-coroutines-and-retrofit-e0702d0b8e8f#targetText=Okay%20so%20Retrofit%20is%20a,Retrofit%20version%20behind%202.6.0.
 */
interface GitHubService {
    @GET("users/chenzhang2006/repos")
    suspend fun getRepos(): Response<List<Repo>> //Response wrapper includes response metadata like response_code
}

data class Repo(val id: Long, val name: String)
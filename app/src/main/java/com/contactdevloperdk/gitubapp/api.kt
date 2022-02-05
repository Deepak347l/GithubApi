package com.contactdevloperdk.gitubapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface api {
    @GET("users/{user}")
    suspend fun getQuotes(@Path("user")user:String) : Response<model>
}
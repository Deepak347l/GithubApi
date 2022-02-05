package com.contactdevloperdk.gitubapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Repapi {
    @GET("{user}/repos")
    fun getQuotesr(@Path("user")user:String) : Call<List<Repmodel>>
}
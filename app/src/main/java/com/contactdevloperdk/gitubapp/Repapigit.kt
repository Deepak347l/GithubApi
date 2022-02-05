package com.contactdevloperdk.gitubapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Repapigit {
    val baseUrl = "https://api.github.com/users/"
    fun getInstancerep(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}
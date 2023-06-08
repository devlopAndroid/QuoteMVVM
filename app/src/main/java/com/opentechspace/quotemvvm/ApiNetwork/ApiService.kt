package com.opentechspace.quotemvvm.ApiNetwork

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val Base_URL = "https://quotable.io/"
    fun getInstance() : Retrofit{
        val instance = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return instance
    }
}
    val api = ApiService.getInstance().create(ApiInterface::class.java)
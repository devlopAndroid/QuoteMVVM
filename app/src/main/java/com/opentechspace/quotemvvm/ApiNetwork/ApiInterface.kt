package com.opentechspace.quotemvvm.ApiNetwork

import com.opentechspace.quotemvvm.Model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/quotes")
    fun getData(@Query ("page") page : Int) : Call<Model>
}
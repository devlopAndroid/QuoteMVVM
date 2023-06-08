package com.opentechspace.quotemvvm.Repository

import com.opentechspace.quotemvvm.ApiNetwork.ApiInterface
import com.opentechspace.quotemvvm.Model.Model
import retrofit2.Call

class MainRepository(val instance : ApiInterface) {

    fun getListData(page : Int): Call<Model> {
         return instance.getData(page)
    }
}
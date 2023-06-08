package com.opentechspace.quotemvvm.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.opentechspace.quotemvvm.Model.Model
import com.opentechspace.quotemvvm.Model.Result
import com.opentechspace.quotemvvm.Repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel(val repository: MainRepository) : ViewModel() {

    val quoteList = MutableLiveData<List<Result>>()

    fun getQuoteList(page : Int)  {
        val response = repository.getListData(page)
        response.enqueue(object : Callback<Model>{
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
               if (response != null)
               {
                   quoteList.value = response.body()!!.results
               }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
               Log.e("failed",t.message.toString())
            }
        })
    }


}
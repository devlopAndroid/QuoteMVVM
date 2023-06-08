package com.opentechspace.quotemvvm.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.opentechspace.quotemvvm.Repository.MainRepository

class MyViewModelFactory(val repository: MainRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MyViewModel::class.java))
        {
            MyViewModel(repository) as T
        }
        else
        {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
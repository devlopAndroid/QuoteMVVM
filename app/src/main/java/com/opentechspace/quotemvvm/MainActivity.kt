package com.opentechspace.quotemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opentechspace.quotemvvm.Adapter.CustomAdapter
import com.opentechspace.quotemvvm.ApiNetwork.api
import com.opentechspace.quotemvvm.Repository.MainRepository
import com.opentechspace.quotemvvm.ViewModel.MyViewModel
import com.opentechspace.quotemvvm.ViewModel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: CustomAdapter
    lateinit var viewModel: MyViewModel
    lateinit var repository: MainRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        repository = MainRepository(api)
        viewModel = ViewModelProvider(this,MyViewModelFactory(repository))
            .get(MyViewModel::class.java)
        viewModel.getQuoteList(1)

        viewModel.quoteList.observe(this, Observer{data->
            recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            myAdapter = CustomAdapter(this@MainActivity,data)
            recycler.adapter = myAdapter
        })
    }
}
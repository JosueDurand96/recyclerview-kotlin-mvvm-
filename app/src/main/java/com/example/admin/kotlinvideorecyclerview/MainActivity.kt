package com.example.admin.kotlinvideorecyclerview

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.admin.kotlinvideorecyclerview.adapter.CustomAdapter
import com.example.admin.kotlinvideorecyclerview.viewmodel.CategoryViewModel


class MainActivity : AppCompatActivity() {

    private var recycleview:RecyclerView?=null
    private var customadapter:CustomAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleview = findViewById(R.id.recyclerview) as RecyclerView

        var categoryViewModel:CategoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)

        categoryViewModel.getArrayList().observe(this, Observer {categoryViewModels->


            customadapter = CustomAdapter(this@MainActivity,categoryViewModels!!)
            recycleview!!.setLayoutManager(LinearLayoutManager(this@MainActivity))
            recycleview!!.setAdapter(customadapter)



        })




    }
}

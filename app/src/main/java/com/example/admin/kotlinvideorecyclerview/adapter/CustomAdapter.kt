package com.example.admin.kotlinvideorecyclerview.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.admin.kotlinvideorecyclerview.R
import com.example.admin.kotlinvideorecyclerview.databinding.CategoryBinding
import com.example.admin.kotlinvideorecyclerview.viewmodel.CategoryViewModel

class CustomAdapter(private val context:Context,private val arrylist:ArrayList<CategoryViewModel>):RecyclerView.Adapter<CustomAdapter.CustomView>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        val layoutInflater = LayoutInflater.from(parent.context)

        val categoryBinding:CategoryBinding = DataBindingUtil.inflate(layoutInflater, R.layout.innerlayout,parent,false)

        return CustomView(categoryBinding)

    }

    override fun getItemCount(): Int {


       return arrylist.size
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

        val categoryViewModel = arrylist[position]
        holder.bind(categoryViewModel)



    }


    class CustomView(val categoryBinding: CategoryBinding):RecyclerView.ViewHolder(categoryBinding.root)


    {
        fun bind (categoryViewModel: CategoryViewModel)
        {

            this.categoryBinding.categorymodel = categoryViewModel
            categoryBinding.executePendingBindings()


        }






    }



}
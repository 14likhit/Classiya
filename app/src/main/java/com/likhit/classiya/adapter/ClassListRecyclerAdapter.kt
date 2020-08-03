package com.likhit.classiya.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likhit.classiya.databinding.LayoutItemClassCardBinding

/**
 * Adapter to show list of classes.
 */
class ClassListRecyclerAdapter() :
    RecyclerView.Adapter<ClassListRecyclerAdapter.ClassListRecyclerViewHolder>() {

    var listClass = mutableListOf<String>()
    var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassListRecyclerViewHolder {
        if(layoutInflater==null){
            layoutInflater= LayoutInflater.from(parent.context)
        }
        return ClassListRecyclerViewHolder(LayoutItemClassCardBinding.inflate(layoutInflater!!,parent,false))
    }

    override fun getItemCount(): Int {
        return listClass.size
    }

    override fun onBindViewHolder(holder: ClassListRecyclerViewHolder, position: Int) {

    }


    class ClassListRecyclerViewHolder(val binding: LayoutItemClassCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}
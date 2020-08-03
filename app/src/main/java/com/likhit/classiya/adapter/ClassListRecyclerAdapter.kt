package com.likhit.classiya.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.likhit.classiya.data.Classe
import com.likhit.classiya.databinding.LayoutItemClassCardBinding
import kotlinx.android.synthetic.main.layout_item_class.view.*
import kotlinx.android.synthetic.main.layout_item_class_card.view.*

/**
 * Adapter to show list of classes.
 */
class ClassListRecyclerAdapter() :
    RecyclerView.Adapter<ClassListRecyclerAdapter.ClassListRecyclerViewHolder>() {

    var listClass = mutableListOf<Classe>()
    var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassListRecyclerViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        return ClassListRecyclerViewHolder(
            LayoutItemClassCardBinding.inflate(
                layoutInflater!!,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listClass.size
    }

    override fun onBindViewHolder(holder: ClassListRecyclerViewHolder, position: Int) {
        val classe = listClass[position]
        holder.binding.classCardLinearLayout.class_card.class_name_text_view.text = classe.className
        holder.binding.classCardLinearLayout.class_card.class_title_text_view.text =
            classe.classTitle
        holder.binding.classCardLinearLayout.class_card.class_title_description_text_view.text =
            classe.classDescription
        holder.binding.classCardLinearLayout.class_card.class_taken_on_date_text_view.text =
            classe.classDate
        holder.binding.classCardLinearLayout.class_card.class_taken_by_name_text_view.text =
            classe.classFaculty
    }


    class ClassListRecyclerViewHolder(val binding: LayoutItemClassCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}
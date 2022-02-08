package com.raimzhanov.adult.domain

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raimzhanov.adult.R

class AdultAdapter():ListAdapter<Adult,AdultViewHolder>(AdultItemDiffCallback()) {

var onAdultItemLongListener:((Adult)->Unit)? = null
var onAdultItemClickListener:((Adult)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdultViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_JUNIOR -> R.layout.adult_list_junior
            VIEW_TYPE_MIDDLE -> R.layout.adult_list_middle
            VIEW_TYPE_SENIOR -> R.layout.adult_list_senior
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return AdultViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdultViewHolder, position: Int) {
  val adult = getItem(position)
        holder.textViewName.text = adult.name
        holder.textViewSurname.text = adult.surname
        holder.textViewAge.text = adult.age.toString()
        holder.textViewType.text = adult.type

        holder.view.setOnClickListener {
            onAdultItemClickListener?.invoke(adult)
        }
        holder.view.setOnLongClickListener {
            onAdultItemLongListener?.invoke(adult)
            true
        }
    }

    override fun getItemViewType(position: Int): Int {
        val adult = getItem(position)
      return  if (adult.age >= VIEW_TYPE_JUNIOR && adult.age< VIEW_TYPE_MIDDLE){
          VIEW_TYPE_JUNIOR
        }
        else if (adult.age >= VIEW_TYPE_MIDDLE && adult.age< VIEW_TYPE_SENIOR){
           VIEW_TYPE_MIDDLE
        } else{
          VIEW_TYPE_SENIOR
        }
    }

    companion object{
const val VIEW_TYPE_JUNIOR = 18
const val VIEW_TYPE_MIDDLE = 35
const val VIEW_TYPE_SENIOR = 45
        const val MAX_POOL_SIZE = 20
        }
}
package com.raimzhanov.adult.domain

import androidx.recyclerview.widget.DiffUtil

class AdultItemDiffCallback:DiffUtil.ItemCallback<Adult>() {

    override fun areItemsTheSame(oldItem: Adult, newItem: Adult): Boolean {
       return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: Adult, newItem: Adult): Boolean {
        return oldItem == newItem
    }
}
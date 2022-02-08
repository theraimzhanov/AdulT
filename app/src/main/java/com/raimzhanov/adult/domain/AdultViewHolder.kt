package com.raimzhanov.adult.domain

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raimzhanov.adult.R

class AdultViewHolder( val  view: View) : RecyclerView.ViewHolder(view) {
    val textViewName: TextView = view.findViewById(R.id.nameAdult)
    val textViewSurname: TextView = view.findViewById(R.id.surnameAdult)
    val textViewAge: TextView = view.findViewById(R.id.ageAdult)
    val textViewType: TextView = view.findViewById(R.id.typeAdult)
}
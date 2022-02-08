package com.raimzhanov.adult.domain

import androidx.lifecycle.LiveData

interface AdultListRepository {

    fun getAdultList():LiveData<List<Adult>>
    fun getAdultItem(id:Int):Adult
    fun addAdult(adult: Adult)
    fun editAdultItem(adult: Adult)
    fun deleteAdultItem(adult: Adult)
}
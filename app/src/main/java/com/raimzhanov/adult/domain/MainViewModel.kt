package com.raimzhanov.adult.domain

import androidx.lifecycle.ViewModel
import com.raimzhanov.adult.data.AdultListRepositoryImpl

class MainViewModel:ViewModel() {

private val repository = AdultListRepositoryImpl

    private val getAdultListUseCase = GetAdultListUseCase(repository)
    private val deleteAdultListUseCase = DeleteAdultItemUseCase(repository)

    fun deleteAdultItem(adult: Adult){
        deleteAdultListUseCase.deleteAdultItem(adult)
    }

    val adultList = getAdultListUseCase.getAdultList()
}
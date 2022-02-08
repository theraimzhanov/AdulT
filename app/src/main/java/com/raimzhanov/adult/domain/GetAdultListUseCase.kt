package com.raimzhanov.adult.domain

import androidx.lifecycle.LiveData

class GetAdultListUseCase(private val repository: AdultListRepository) {

 fun getAdultList():LiveData<List<Adult>>{
     return repository.getAdultList()
 }
}
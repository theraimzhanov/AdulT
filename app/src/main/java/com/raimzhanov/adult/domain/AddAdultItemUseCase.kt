package com.raimzhanov.adult.domain

class AddAdultItemUseCase(private val repository: AdultListRepository) {

 fun addAdultItem(adult: Adult){
     repository.addAdult(adult)
 }
}
package com.raimzhanov.adult.domain

class EditAdultItemUseCase(private val repository: AdultListRepository) {

 fun editAdultItem(adult: Adult){
     repository.editAdultItem(adult)
 }
}

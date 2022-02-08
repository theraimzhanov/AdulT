package com.raimzhanov.adult.domain

class DeleteAdultItemUseCase(private val repository: AdultListRepository) {

 fun deleteAdultItem(adult: Adult){
     repository.deleteAdultItem(adult)
 }
}
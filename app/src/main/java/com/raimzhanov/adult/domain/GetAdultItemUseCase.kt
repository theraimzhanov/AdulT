package com.raimzhanov.adult.domain

class GetAdultItemUseCase(private val repository: AdultListRepository) {

 fun getAdultItem(id:Int):Adult{
return repository.getAdultItem(id)
 }
}
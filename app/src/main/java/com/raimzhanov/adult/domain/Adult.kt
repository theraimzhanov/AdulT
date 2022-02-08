package com.raimzhanov.adult.domain

data class Adult(val name:String,val surname:String,val age:Int,val type:String,var id:Int = UN_KNOW_ID) {

    companion object{
        const val UN_KNOW_ID = -11
    }
}
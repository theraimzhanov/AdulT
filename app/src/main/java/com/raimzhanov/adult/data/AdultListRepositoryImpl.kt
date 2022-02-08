package com.raimzhanov.adult.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raimzhanov.adult.domain.Adult
import com.raimzhanov.adult.domain.AdultListRepository
import java.lang.RuntimeException
import kotlin.random.Random

object AdultListRepositoryImpl : AdultListRepository {

    private val adultListLD = MutableLiveData<List<Adult>>()
    private val adultList = sortedSetOf<Adult>({ a1, a2 -> a1.id.compareTo(a2.id) })

    private var autoId = 0

init {
for (i in 0 until 100){
   val type = getType()
val item =Adult("Adult $i","Adult $i",i+18,type)
    addAdult(item)
}
}

    private fun getType():String{
       return if (Random.nextBoolean()){
            "male"
        } else{
            "female"
       }
    }



    override fun getAdultList(): LiveData<List<Adult>> {
        return adultListLD
    }

    override fun getAdultItem(id: Int): Adult {
return adultList.find {
it.id == id
} ?: throw RuntimeException("Элемент не найден")
    }

    override fun addAdult(adult: Adult) {
        if (adult.id == Adult.UN_KNOW_ID) {
            adult.id = autoId++
        }
        adultList.add(adult)
        updateList()
    }

    override fun editAdultItem(adult: Adult) {
        val oldElement = getAdultItem(adult.id)
        adultList.remove(oldElement)
        addAdult(adult)
    }

    override fun deleteAdultItem(adult: Adult) {
        adultList.remove(adult)
        updateList()
    }
    private fun updateList(){
  adultListLD.value = adultList.toList()
    }
}
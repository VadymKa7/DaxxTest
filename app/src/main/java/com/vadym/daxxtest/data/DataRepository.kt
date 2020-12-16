package com.vadym.daxxtest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.vadym.daxxtest.api.AppService
import com.vadym.daxxtest.model.ComplicatedObject
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository  @Inject constructor(private val service: AppService){

    fun getNewsList (oPage: Int, oLimit: Int): LiveData<ComplicatedObject> {
        return liveData(Dispatchers.IO) {
            try {
                val newsList = service.getNewsList(oPage,oLimit)
                emit(newsList)
            }catch (er: Exception){
                er.printStackTrace()
            }
        }
    }
}
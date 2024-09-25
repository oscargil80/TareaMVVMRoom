package com.oscargil80.tareasroommvvm.Repository

import androidx.lifecycle.LiveData
import com.oscargil80.tareasroommvvm.Dao.PersonalDao
import com.oscargil80.tareasroommvvm.Model.Personal

class PersonalRepository(val dao: PersonalDao) {

    fun getAllPersonal(): LiveData<List<Personal>>{
        return dao.getPersonal()
    }

    fun insertPersonal(personal: Personal){
        dao.insertPersonal(personal)
    }

    fun deletePersonal(id:Int){
        return dao.deletePersonal(id)
    }

    fun updatePersonal(personal: Personal){
        return dao.updatePersonal(personal)
    }

}
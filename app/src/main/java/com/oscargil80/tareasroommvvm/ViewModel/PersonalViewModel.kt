package com.oscargil80.tareasroommvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.oscargil80.tareasroommvvm.Database.PersonalDatabase
import com.oscargil80.tareasroommvvm.Model.Personal
import com.oscargil80.tareasroommvvm.Repository.PersonalRepository

class PersonalViewModel(application: Application): AndroidViewModel(application) {

    val repository: PersonalRepository

    init {
        val dao = PersonalDatabase.getDatabaseInstance(application).myPersonalDao()
        repository = PersonalRepository(dao)
    }

/*
    fun getAllPersonal(): LiveData<List<Personal>>{
       return repository.getAllPersonal()
    }
*/

    fun getAllPersonal(): LiveData<List<Personal>> = repository.getAllPersonal()

    fun insertPersonal (personal: Personal){
        repository.insertPersonal(personal)
    }

    fun updatePersonal(personal: Personal){
        repository.updatePersonal(personal)
    }

    fun deletePersonal(id : Int){
        repository.deletePersonal(id)
    }



}
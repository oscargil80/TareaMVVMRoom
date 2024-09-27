package com.oscargil80.tareasroommvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.oscargil80.tareasroommvvm.Database.PaisesDatabase
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.Respsitory.PaisesRepository

class PaisesViewModel(application: Application): AndroidViewModel(application) {

    val repository : PaisesRepository

    init{
        val dao = PaisesDatabase.getDatabaseInstance(application).myPaisesDao()
        repository = PaisesRepository(dao)
    }

    fun getPaises(): LiveData<List<Paises>> = repository.getAllPaises()


    fun addPaises(pais: Paises){
        repository.insertPaises(pais)
    }

    fun deletePaises(id: Int){
        repository.deletePaises(id)
    }

    fun updatePaises(pais: Paises){
        repository.updatePaises(pais)
    }
}
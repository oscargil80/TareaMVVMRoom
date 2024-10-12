package com.oscargil80.tareasroommvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oscargil80.tareasroommvvm.Database.PaisesDatabase
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.Repository.PaisesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaisesViewModel(application: Application) : AndroidViewModel(application) {

    val repository: PaisesRepository

    init {
        val dao = PaisesDatabase.getDatabaseInstance(application).myPaisesDao()
        repository = PaisesRepository(dao)
    }

    fun getAllPaises(): LiveData<List<Paises>> = repository.getAllPaises()

    fun getPaisById(id: Int): LiveData<Paises> = repository.getPaisByID(id)

    fun insertPais(pais: Paises) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPais(pais)
        }
    }

    fun updatePais(pais: Paises) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePis(pais)
        }
    }

    fun deletePais(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePais(id)
        }
    }

}
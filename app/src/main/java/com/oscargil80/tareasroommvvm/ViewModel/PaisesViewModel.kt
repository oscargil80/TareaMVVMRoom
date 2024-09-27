package com.oscargil80.tareasroommvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oscargil80.tareasroommvvm.Database.PaisesDatabase
import com.oscargil80.tareasroommvvm.Model.Paises
import com.oscargil80.tareasroommvvm.Respsitory.PaisesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PaisesViewModel(application: Application) : AndroidViewModel(application) {

    val repository: PaisesRepository

    init {
        val dao = PaisesDatabase.getDatabaseInstance(application).myPaisesDao()
        repository = PaisesRepository(dao)
    }

    fun getPaises(): LiveData<List<Paises>> = repository.getAllPaises()


    fun addPaises(pais: Paises) = GlobalScope.launch {
        repository.insertPaises(pais)
    }

    fun deletePaises(id: Int) {
        GlobalScope.launch {
            repository.deletePaises(id)
        }
    }

    fun updatePaises(pais: Paises) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePaises(pais)
        }
    }
}
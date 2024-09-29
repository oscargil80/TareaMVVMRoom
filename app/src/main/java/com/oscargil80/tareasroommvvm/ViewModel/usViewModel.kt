package com.oscargil80.tareasroommvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oscargil80.tareasroommvvm.Dao.UsuariosDao
import com.oscargil80.tareasroommvvm.Database.UsuariosDatabase
import com.oscargil80.tareasroommvvm.Model.Usuarios
import com.oscargil80.tareasroommvvm.Repository.UsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class usViewModel(application: Application) : AndroidViewModel(application) {

    val repository: UsRepository

    init {
        val dao = UsuariosDatabase.getDatabaseInstance(application).myUsDao()
        repository = UsRepository(dao)
    }

    fun getAllUs(): LiveData<List<Usuarios>> = repository.getAllUs()

    fun insertUs(usuario: Usuarios) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUs(usuario)
        }
    }

    fun updateUs(usuario: Usuarios) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUs(usuario)
        }
    }
    //fun deleteUs(id:Int) = repository.deleteUs(id)
    fun deleteUs(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUs(id)
        }
    }

}
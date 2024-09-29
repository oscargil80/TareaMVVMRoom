package com.oscargil80.tareasroommvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.oscargil80.tareasroommvvm.Dao.UsuariosDao
import com.oscargil80.tareasroommvvm.Database.UsuariosDatabase
import com.oscargil80.tareasroommvvm.Model.Usuarios
import com.oscargil80.tareasroommvvm.Repository.UsRepository


class usViewModel(application: Application): AndroidViewModel(application) {

    val repository: UsRepository

    init {
        val dao = UsuariosDatabase.getDatabaseInstance(application).myUsDao()
        repository = UsRepository(dao)
    }

        fun getAllUs(): LiveData<List<Usuarios>> = repository.getAllUs()

        fun insertUs(usuario: Usuarios) = repository.insertUs(usuario)

        fun updateUs(usuario: Usuarios) = repository.updateUs(usuario)

        //fun deleteUs(id:Int) = repository.deleteUs(id)

        fun deleteUs(id:Int){
            return repository.deleteUs(id)
        }

}
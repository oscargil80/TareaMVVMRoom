package com.oscargil80.tareasroommvvm.Repository

import androidx.lifecycle.LiveData
import com.oscargil80.tareasroommvvm.Dao.UsuariosDao
import com.oscargil80.tareasroommvvm.Model.Usuarios


class UsRepository(val dao: UsuariosDao) {

      fun getAllUs(): LiveData<List<Usuarios>> = dao.getAllUS()

    suspend fun insertUs(usuario: Usuarios) = dao.insertUsuario(usuario)

    suspend fun updateUs(usuario: Usuarios) = dao.updateUsuario(usuario)

    suspend  fun deleteUs(id:Int) = dao.deleteUsuario(id)


}
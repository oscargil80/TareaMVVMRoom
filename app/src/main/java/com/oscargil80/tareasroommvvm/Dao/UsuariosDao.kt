package com.oscargil80.tareasroommvvm.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oscargil80.tareasroommvvm.Model.Usuarios


@Dao
interface UsuariosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsuario(usuario: Usuarios)

    @Update
    fun updateUsuario(usuario: Usuarios)

    @Query("DELETE FROM Usuarios WHERE id =:id")
    fun deleteUsuario(id: Int)

    @Query("SELECT * FROM Usuarios")
    fun getAllUS():LiveData<List<Usuarios>>





}
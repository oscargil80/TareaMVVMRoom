package com.oscargil80.tareasroommvvm.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oscargil80.tareasroommvvm.Model.Usuarios


@Dao
interface UsuariosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsuario(usuario: Usuarios)

    @Update
    suspend fun updateUsuario(usuario: Usuarios)

    @Query("DELETE FROM Usuarios WHERE id =:id")
    suspend fun deleteUsuario(id: Int)

    @Query("SELECT * FROM Usuarios")
    fun getAllUS():LiveData<List<Usuarios>>


}
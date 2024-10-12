package com.oscargil80.tareasroommvvm.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oscargil80.tareasroommvvm.Model.Paises


@Dao
interface paisesDao {

    @Query("SELECT * FROM  Paises")
    fun getAllPaises(): LiveData<List<Paises>>

    @Query("SELECT * FROM Paises WHERE id=:id ")
    fun getPaisById(id: Int): LiveData<Paises>

    //TODO Verificar si puedo poner la funcion update e insert en el mismo
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPais(pais: Paises)

    @Update
    suspend fun updatePais(pais: Paises)

    //TODO Verificar y cambiar la anotacion a @DELETE
    @Query("DELETE FROM Paises WHERE id = :id")
    suspend fun deletePais(id: Int)

}
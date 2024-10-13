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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPais(pais: Paises)

    @Delete
    suspend fun deletePais(pais: Paises)

}
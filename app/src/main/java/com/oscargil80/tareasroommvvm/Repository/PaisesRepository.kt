package com.oscargil80.tareasroommvvm.Repository

import androidx.lifecycle.LiveData
import com.oscargil80.tareasroommvvm.Dao.paisesDao
import com.oscargil80.tareasroommvvm.Model.Paises

class PaisesRepository(val dao:paisesDao) {

    fun getAllPaises(): LiveData<List<Paises>> = dao.getAllPaises()

    fun  getPaisByID(id:Int): LiveData<Paises> = dao.getPaisById(id)


    suspend fun insertPais(pais: Paises) = dao.insertPais(pais)

    suspend fun deletePais(pais: Paises) = dao.deletePais(pais)

}
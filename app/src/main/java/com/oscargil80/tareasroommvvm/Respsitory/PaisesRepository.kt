package com.oscargil80.tareasroommvvm.Respsitory

import androidx.lifecycle.LiveData
import com.oscargil80.tareasroommvvm.Dao.PaisesDao
import com.oscargil80.tareasroommvvm.Model.Paises

class PaisesRepository(val dao: PaisesDao) {

/*    fun getAllNotes(): LiveData<List<Notes>>{
        return dao.getNotes()
    }*/

    fun getAllPaises(): LiveData<List<Paises>> = dao.getPaises()


    fun insertPaises(pais: Paises) = dao.insertPaises(pais)


    fun deletePaises(id: Int) {
        dao.deletePaises(id)
    }

    fun updatePaises(pais: Paises) {
        dao.updatePaises(pais)
    }
}
package com.oscargil80.tareasroommvvm.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oscargil80.tareasroommvvm.Model.Paises

@Dao
interface PaisesDao {

    @Query("SELECT * FROM Paises")
    fun getPaises(): LiveData<List<Paises>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPaises(pais:Paises)

    @Query("DELETE FROM Paises WHERE id=:id ")
    fun deletePaises(id: Int)

    @Update
    fun updatePaises(pais: Paises)

}
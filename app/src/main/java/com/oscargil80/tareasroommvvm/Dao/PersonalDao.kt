package com.oscargil80.tareasroommvvm.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oscargil80.tareasroommvvm.Model.Personal


@Dao
interface PersonalDao {

    @Query("SELECT * FROM Personal")
    fun getPersonal(): LiveData<List<Personal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPersonal(personal: Personal)

    @Update
    fun updatePersonal(personal: Personal)

    @Query("SELECT * FROM Personal WHERE id= :id")
    fun getPersonalById(id:Int): LiveData<List<Personal>>

    @Query (" DELETE FROM Personal WHERE id=:id")
    fun deletePersonal(id:Int)

}
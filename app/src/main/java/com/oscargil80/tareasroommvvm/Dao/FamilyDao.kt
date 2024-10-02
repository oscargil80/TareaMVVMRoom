package com.oscargil80.tareasroommvvm.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oscargil80.tareasroommvvm.Model.Family


@Dao
interface FamilyDao {

    @Query("SELECT * FROM Family")
    fun gatAllFamily(): LiveData<List<Family>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertFamily(family:Family)

    @Update
    suspend fun updateFamily(family: Family)



    @Query("DELETE  FROM Family WHERE id=:id ")
    suspend fun deleteFamily(id:Int)


}
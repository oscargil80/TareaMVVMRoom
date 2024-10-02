package com.oscargil80.tareasroommvvm.Repository

import androidx.lifecycle.LiveData
import com.oscargil80.tareasroommvvm.Dao.FamilyDao
import com.oscargil80.tareasroommvvm.Model.Family


class familyRepitory(val dao:FamilyDao) {

    fun getAllFamily(): LiveData<List<Family>> = dao.gatAllFamily()

    suspend fun insertFamily(family:Family) = dao.insertFamily(family)

    suspend fun updateFamily(family: Family) = dao.updateFamily(family)

    suspend fun deleteFamily(id: Int) = dao.deleteFamily(id)


}
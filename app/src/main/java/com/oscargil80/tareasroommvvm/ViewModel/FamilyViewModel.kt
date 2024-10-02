package com.oscargil80.tareasroommvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oscargil80.tareasroommvvm.Database.FamilyDatabase
import com.oscargil80.tareasroommvvm.Model.Family
import com.oscargil80.tareasroommvvm.Repository.familyRepitory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FamilyViewModel(application: Application):AndroidViewModel(application){

    val repository:familyRepitory

    init {
        val dao = FamilyDatabase.getDatabaseInstance(application).myFamilyDao()
        repository = familyRepitory(dao)
    }

    fun getAllFamily() : LiveData<List<Family>> = repository.getAllFamily()

    fun insertFamily(family: Family){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertFamily(family)
        }
    }

    fun updateFamily(family: Family){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateFamily(family)
        }
    }

    fun deleteFamily(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFamily(id)
        }
    }


}
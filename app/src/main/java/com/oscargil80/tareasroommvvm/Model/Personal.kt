package com.oscargil80.tareasroommvvm.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Personal")
data class Personal(
    @PrimaryKey(autoGenerate = true)
    var id:Int?= null,
    var cedula:String,
    var nombre : String,
    var  dir : String
):Parcelable

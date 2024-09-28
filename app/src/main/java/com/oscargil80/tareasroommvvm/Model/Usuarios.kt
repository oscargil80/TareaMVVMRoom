package com.oscargil80.tareasroommvvm.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Usuarios")
data class Usuarios(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val usuario:String,
    val clave:String,
    val descripcion: String
):Parcelable

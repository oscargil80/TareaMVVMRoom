package com.oscargil80.tareasroommvvm.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
class Paises(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nombre: String,
    val capital: String,
    val continente: String
) : Parcelable

package com.oscargil80.tareasroommvvm.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

// poner data class a ver si funciona igual
// poner @Parceize cando vamos a pasar argumentos en el navargs
@Parcelize

@Entity(tableName = "Paises")
data class Paises(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var codigoPais: String,
    var nombrePais: String,
    var continentePais: String,
): Parcelable

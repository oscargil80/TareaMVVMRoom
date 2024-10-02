package com.oscargil80.tareasroommvvm.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Family(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var parentesco: String,
    var nombre: String,
    var apellido: String
) : Parcelable

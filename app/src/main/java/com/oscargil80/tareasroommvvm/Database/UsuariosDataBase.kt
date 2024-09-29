package com.oscargil80.tareasroommvvm.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oscargil80.tareasroommvvm.Dao.UsuariosDao
import com.oscargil80.tareasroommvvm.Model.Usuarios


@Database(entities = [Usuarios::class], version = 1, exportSchema = false)
abstract class UsuariosDatabase : RoomDatabase() {

    abstract fun myUsDao(): UsuariosDao

    companion object {
        @Volatile
        var INSTANCE: UsuariosDatabase? = null

        fun getDatabaseInstance(context: Context): UsuariosDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            synchronized(this)
            {
                val roomDatabaseInstance =
                    Room.databaseBuilder(
                        context, UsuariosDatabase::class.java, "Usuarios"
                    ).allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return return roomDatabaseInstance
            }
        }
    }
}
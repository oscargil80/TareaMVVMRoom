package com.oscargil80.tareasroommvvm.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oscargil80.tareasroommvvm.Dao.PaisesDao
import com.oscargil80.tareasroommvvm.Model.Paises

@Database(entities = [Paises::class], version = 1, exportSchema = false)
abstract class PaisesDatabase : RoomDatabase() {

    abstract fun myPaisesDao(): PaisesDao

    companion object {
        @Volatile
        var INSTANCE: PaisesDatabase? = null

        fun getDatabaseInstance(context: Context): PaisesDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {
                val roomDatabaseInstance =
                    Room.databaseBuilder(context, PaisesDatabase::class.java, "Paises"
                    ).allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return return roomDatabaseInstance
            }
        }
    }

}
package com.oscargil80.tareasroommvvm.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oscargil80.tareasroommvvm.Dao.FamilyDao
import com.oscargil80.tareasroommvvm.Model.Family


@Database(entities = [Family::class], version = 1, exportSchema = false)
abstract class FamilyDatabase : RoomDatabase() {

    abstract fun myFamilyDao(): FamilyDao

    companion object {
        @Volatile
        var INSTANCE: FamilyDatabase? = null

        fun getDatabaseInstance(context: Context): FamilyDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            synchronized((this))
            {
                val roomDatabaseInstance =
                    Room.databaseBuilder(
                        context, FamilyDatabase::class.java, "Family"
                    ).allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return return roomDatabaseInstance
            }
        }
    }

}
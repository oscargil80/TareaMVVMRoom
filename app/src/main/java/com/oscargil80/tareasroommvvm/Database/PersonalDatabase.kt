package com.oscargil80.tareasroommvvm.Database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oscargil80.tareasroommvvm.Dao.PersonalDao
import com.oscargil80.tareasroommvvm.Model.Personal


@Database(entities = [Personal::class], version = 1, exportSchema = false)
abstract class PersonalDatabase : RoomDatabase() {

    abstract fun myPersonalDao(): PersonalDao

    companion object {
        @Volatile
        var INSTANCE: PersonalDatabase? = null

        fun getDatabaseInstance(context: Context): PersonalDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val roomDatabaseInstance =
                    Room.databaseBuilder(context, PersonalDatabase::class.java, "Personal")
                        .allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return return roomDatabaseInstance
            }
        }
    }
}
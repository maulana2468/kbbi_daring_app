package com.maulanayusuf034.kbbidaring.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Kosakata::class],
    version = 1
)

abstract class KosakataDB : RoomDatabase(){
    abstract fun kosakataDB() : KosakataDao

    companion object {
        @Volatile private var instance : KosakataDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            KosakataDB::class.java,
            "kosakata542.db"
        ).build()
    }
}
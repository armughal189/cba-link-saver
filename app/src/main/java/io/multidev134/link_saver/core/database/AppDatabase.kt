package io.multidev134.link_saver.core.database

import androidx.room3.Database
import androidx.room3.RoomDatabase

@Database(entities = [LinkEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
  abstract fun linkDao(): LinkDao
}

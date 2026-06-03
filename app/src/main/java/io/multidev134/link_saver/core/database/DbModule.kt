package io.multidev134.link_saver.core.database

import android.content.Context
import androidx.room3.Room
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("io.multidev134.link_saver.core")
class DbModule {
  @Single
  fun provideDatabase(
    context: Context
  ): AppDatabase {
    return Room.databaseBuilder(
      context,
      AppDatabase::class.java,
      "linksaver_db"
    ).build()
  }
  @Single
  fun provideLinkDao(
    db: AppDatabase
  ): LinkDao {
    return db.linkDao()
  }
}

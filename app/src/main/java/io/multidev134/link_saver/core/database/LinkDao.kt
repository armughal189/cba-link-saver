package io.multidev134.link_saver.core.database

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LinkDao {
  @Query("SELECT * FROM links ORDER BY id DESC")
  fun getAll(): Flow<List<LinkEntity>>

  @Insert
  suspend fun addLink(link: LinkEntity)

  @Update
  suspend fun modLink(link: LinkEntity)

  @Delete
  suspend fun deleteLink(link: LinkEntity)
}
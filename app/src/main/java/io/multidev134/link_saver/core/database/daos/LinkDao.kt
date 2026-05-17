package io.multidev134.link_saver.core.database.daos

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import io.multidev134.link_saver.core.database.entities.LinkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LinkDao {
  @Query("SELECT * FROM links")
  fun getAll(): Flow<List<LinkEntity>>

  @Insert
  suspend fun addLink(link: LinkEntity)

  @Update
  suspend fun modLink(link: LinkEntity)

  @Delete
  suspend fun removeLink(link: LinkEntity)
}

package io.multidev134.link_saver.core.database

import androidx.room3.Entity
import androidx.room3.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "links")
data class LinkEntity(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val title: String,
  val desc: String = "",
  val url: String
)

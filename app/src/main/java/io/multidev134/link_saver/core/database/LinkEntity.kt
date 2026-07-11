package io.multidev134.link_saver.core.database

import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "links")
data class LinkEntity(
  @PrimaryKey val id: String = NanoIdUtils.randomNanoId(),
  val title: String,
  val desc: String = "",
  val url: String,
val userId: String = "Something"
)

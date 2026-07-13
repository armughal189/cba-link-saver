package io.multidev134.link_saver.features.auth

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
  val id: String,
  val display_name: String
)

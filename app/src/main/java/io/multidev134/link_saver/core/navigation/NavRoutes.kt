package io.multidev134.link_saver.core.navigation

import androidx.navigation3.runtime.NavKey
import io.multidev134.link_saver.core.database.LinkEntity
import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoutes: NavKey {
  @Serializable data object Welcome: NavRoutes()
  @Serializable data object Home: NavRoutes()
  @Serializable data object About: NavRoutes()
  @Serializable data object AddLink: NavRoutes()
  @Serializable data class LinkDetails(val link: LinkEntity): NavRoutes()
  @Serializable data class UpdateLink(val link: LinkEntity): NavRoutes()
}

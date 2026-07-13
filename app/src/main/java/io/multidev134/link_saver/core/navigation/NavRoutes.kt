package io.multidev134.link_saver.core.navigation

import androidx.navigation3.runtime.NavKey
import io.multidev134.link_saver.core.database.LinkEntity
import kotlinx.serialization.Serializable

interface  NavRoutes: NavKey {
  @Serializable data object Welcome: NavRoutes
  @Serializable data object Signup: NavRoutes
  @Serializable data object Login: NavRoutes
  @Serializable data object Home: NavRoutes
  @Serializable data object More: NavRoutes
  @Serializable data class LinkDetails(val link: LinkEntity): NavRoutes
  @Serializable data object Settings: NavRoutes
  @Serializable data object WhatsNew: NavRoutes
}

package io.multidev134.link_saver.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
  val route: NavRoutes,
  val label: String,
  val icon: ImageVector
)

val navItems = listOf(
  NavItem(
    route = NavRoutes.Home,
    label = "Home",
    icon = Icons.Default.Home
  ),
  NavItem(
    route = NavRoutes.More,
    label = "More",
    icon = Icons.Default.Menu
  ),
  NavItem(
    route = NavRoutes.Settings,
    label = "Settings",

    icon = Icons.Default.Settings
  )
)

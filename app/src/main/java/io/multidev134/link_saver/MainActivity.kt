package io.multidev134.link_saver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.core.navigation.navItems
import io.multidev134.link_saver.features.about.ui.AboutScreen
import io.multidev134.link_saver.features.add_link.ui.AddLinkScreen
import io.multidev134.link_saver.features.link_details.ui.LinkDetailsScreen
import io.multidev134.link_saver.features.links_list.ui.LinksListScreen
import io.multidev134.link_saver.features.update_link.ui.UpdateLinkScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val backStack = rememberNavBackStack(NavRoutes.Home)
      val currentRoute = backStack.last()

      CompositionLocalProvider(LocalBackStack provides backStack) {
        NavigationSuiteScaffold(
          navigationSuiteItems = {
            navItems.forEach { navItem ->
              item(
                selected = currentRoute == navItem.route,
                onClick = {
                  if (currentRoute != navItem.route) {
                    backStack.clear()
                    backStack.add(navItem.route)
                  }
                },
                icon = { Icon(navItem.icon, contentDescription = navItem.label) },
                label = { Text(navItem.label) }
              )
            }
          }
        ) {
          NavDisplay(
            backStack = backStack,
            onBack = {
              backStack.removeLastOrNull()
            },
            entryProvider = entryProvider {
              entry<NavRoutes.Home> {
                LinksListScreen()
              }
              entry<NavRoutes.About> {
                AboutScreen()
              }
              entry<NavRoutes.AddLink> {
                AddLinkScreen()
              }
              entry<NavRoutes.LinkDetails> { route ->
                LinkDetailsScreen(route.link)
              }
              entry<NavRoutes.UpdateLink> { route ->
                UpdateLinkScreen(route.link)
              }
            })
        }
      }
    }
  }
}

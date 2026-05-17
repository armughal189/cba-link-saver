package io.multidev134.link_saver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.features.add_link.ui.AddLinkScreen
import io.multidev134.link_saver.features.links_list.ui.LinksListScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val backStack = rememberNavBackStack(NavRoutes.Home)
      CompositionLocalProvider(LocalBackStack provides backStack) {
        NavDisplay(
          backStack = backStack,
          onBack = {
            backStack.removeLastOrNull()
          },
          entryProvider = entryProvider {
            entry<NavRoutes.Home> {
              LinksListScreen()
            }
            entry<NavRoutes.AddLink> {
              AddLinkScreen()
            }
          })
      }
    }
  }
}

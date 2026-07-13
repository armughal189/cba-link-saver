package io.multidev134.link_saver

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.Icon
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.fragment.app.FragmentActivity
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.preference.PreferenceManager
import io.multidev134.link_saver.core.navigation.LocalBackStack
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.core.navigation.navItems
import io.multidev134.link_saver.features.more.ui.MoreScreen
import io.multidev134.link_saver.features.link_details.ui.LinkDetailsScreen
import io.multidev134.link_saver.features.links_list.ui.LinksListScreen
import io.multidev134.link_saver.features.settings.ui.SettingsScreen
import io.multidev134.link_saver.features.settings.ui.handleThemeMode
import io.multidev134.link_saver.features.whats_new.WhatsNewScreen
import io.multidev134.link_saver.features.auth.signup.SignupScreen
import io.multidev134.link_saver.features.auth.login.LoginScreen
import io.multidev134.link_saver.features.welcome.WelcomeScreen

class MainActivity : FragmentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    val themeMode = prefs.getString("theme_mode", "system") ?: "system"
    handleThemeMode(themeMode)
    super.onCreate(savedInstanceState)
    setContent {
      val backStack = rememberNavBackStack(NavRoutes.Welcome)
      val currentRoute = backStack.last()

      CompositionLocalProvider(LocalBackStack provides backStack) {
        NavigationSuiteScaffold(
          navigationSuiteItems = {
            if (currentRoute != NavRoutes.Welcome &&
              currentRoute != NavRoutes.Signup &&
              currentRoute != NavRoutes.Login
            ) {
              navItems.forEach { navItem ->
                item(
                  selected = currentRoute == navItem.route,
                  onClick = {
                    if (currentRoute != navItem.route) {
                      backStack.clear()
                      backStack.add(navItem.route)
                    }
                  },
                  icon = { Icon(navItem.icon, contentDescription = navItem.label) }
                )
              }
            }
          }) {
          NavDisplay(
            backStack = backStack,
            onBack = {
              backStack.removeLastOrNull()
            },
            entryProvider = entryProvider {
              entry<NavRoutes.Welcome> {
                WelcomeScreen()
              }
              entry<NavRoutes.Home> {
                LinksListScreen()
              }
              entry<NavRoutes.Signup> {
                SignupScreen()
              }
              entry<NavRoutes.Login> {
                LoginScreen()
              }
              entry<NavRoutes.More> {
                MoreScreen()
              }
              entry<NavRoutes.Settings> {
                SettingsScreen()
              }
              entry<NavRoutes.WhatsNew> {
                WhatsNewScreen()
              }
              entry<NavRoutes.LinkDetails> { route ->
                LinkDetailsScreen(route.link)
              }
            })
        }
      }
    }
  }
}

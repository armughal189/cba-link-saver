package io.multidev134.link_saver.features.welcome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import io.multidev134.link_saver.core.navigation.LocalBackStack
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.features.auth.AuthVM
import io.multidev134.reuse_hub.ui.widget.base.CbaButton
import io.multidev134.reuse_hub.ui.widget.base.CbaTextView
import io.multidev134.reuse_hub.ui.widget.layout.CbaLayout
import io.multidev134.reuse_hub.ui.widget.layout.CbaSpacer
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WelcomeScreen(
  vm: AuthVM = koinViewModel()
) {
  val backStack = LocalBackStack.current
  val isLoggedIn = vm.isLoggedIn()

  LaunchedEffect(isLoggedIn) {
    if (isLoggedIn) {
      backStack.clear()
      backStack.add(NavRoutes.Home)
    }
  }

  if (!isLoggedIn) {
    CbaLayout("Welcome to Link Saver by Code and Big Apple") {
      CbaTextView("This is a Free, Open Source and Accessible Application that lets you manage your links effortlessly.")
      CbaTextView("Get Started by creating or logging-in with your Account")
      CbaSpacer()
      CbaButton(
        label = "SignUp",
        onClick = {
          backStack.add(NavRoutes.Signup)
        })
      CbaSpacer(spacing = 12)
      CbaButton(
        label = "Login",
        onClick = {
          backStack.add(NavRoutes.Login)
        })
    }
  }
}
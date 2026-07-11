package io.multidev134.link_saver.features.auth.signup

import androidx.compose.runtime.Composable
import io.multidev134.link_saver.core.navigation.LocalBackStack
import io.multidev134.link_saver.features.auth.AuthVM
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignupScreen(
  vm: AuthVM = koinViewModel()
) {
  val backStack = LocalBackStack.current
  Cba
}

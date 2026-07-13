package io.multidev134.link_saver.features.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.multidev134.link_saver.core.navigation.LocalBackStack
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.reuse_hub.ui.widget.base.CbaButton
import io.multidev134.reuse_hub.ui.widget.base.CbaTextView
import io.multidev134.reuse_hub.ui.widget.layout.CbaLayout
import io.multidev134.reuse_hub.ui.widget.layout.CbaSpacer
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileScreen(
  vm: ProfileVM = koinViewModel()
) {
  val backStack = LocalBackStack.current

  CbaLayout("Profile") {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      CbaTextView("Name: ${vm.displayName}", isHeading = true, level = 2)
      CbaSpacer(12)
      CbaTextView("Email: ${vm.email}")
      CbaSpacer(32)
      CbaButton(
        label = "Sign Out",
        onClick = {
          vm.signout {
            backStack.clear()
            backStack.add(NavRoutes.Welcome)
          }
        }
      )
    }
  }
}

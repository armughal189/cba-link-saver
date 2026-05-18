package io.multidev134.link_saver.features.links_list.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.reuse_hub.ui.widget.CbaButton

@Composable
fun CreateLinkBtn() {
  val backStack = LocalBackStack.current
  CbaButton(
    label = "Create a new Link",
    onClick = {
      backStack.add(NavRoutes.AddLink)
    },
    modifier = Modifier.fillMaxWidth()
  )
}

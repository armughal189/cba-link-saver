package io.multidev134.link_saver.features.links_list.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.multidev134.reuse_hub.ui.widget.CbaColumn
import io.multidev134.reuse_hub.ui.widget.CbaTextView

@Composable
fun NoLinksUi() {
  CbaColumn {
    CbaTextView(
      text = "You have No Links Right now. Get Started by Creating your First Link",
      modifier = Modifier.fillMaxWidth()
    )
  }
}

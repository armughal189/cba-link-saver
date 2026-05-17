package io.multidev134.link_saver.features.links_list.ui

import androidx.compose.runtime.Composable
import io.multidev134.reuse_hub.ui.widget.CbaColumn
import io.multidev134.reuse_hub.ui.widget.CbaTextView

@Composable
fun NoLinksUi() {
  CbaColumn {
    CbaTextView("You have No Links Right now. Get Started by Creating your First Link")
    CreateLinkBtn()
  }
}
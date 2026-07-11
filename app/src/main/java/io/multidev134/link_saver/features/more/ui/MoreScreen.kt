package io.multidev134.link_saver.features.more.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import io.multidev134.link_saver.core.navigation.LocalBackStack
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.reuse_hub.ui.widget.base.CbaClickableView
import io.multidev134.reuse_hub.ui.widget.layout.CbaColumn
import io.multidev134.reuse_hub.ui.widget.layout.CbaLayout
import io.multidev134.reuse_hub.ui.widget.base.CbaLink
import io.multidev134.reuse_hub.ui.widget.base.CbaTextView
import io.multidev134.reuse_hub.utils.shareText

@Composable
fun MoreScreen() {
  val context = LocalContext.current
  val backStack = LocalBackStack.current
  CbaLayout("More") {
    CbaColumn {
      CbaTextView("A Free, Open Source and Accessible Application that remembers and Allows you Open, Copy and Share your Links with eas.")
      CbaTextView("Developed by Abdul Rehman Mughal (The Prince) from \"Code and Big Apple\"")
      CbaLink("View Source code on GitHub", "https://github.com/armughal189/cba-link-saver")
      Spacer(Modifier.height(8.dp))
      CbaTextView(
        text = "Our Social Media Handles",
        isHeading = true
      )
      CbaLink(
        label = "Email",
        url = "mailto:samughal189@gmail.com?subject=Something about Link Saver"
      )
      CbaLink(
        label = "GitHub Profile",
        url = "https://github.com/armughal189"
      )
      CbaLink(
        label = "YouTube Channel (Abdul Rehman Mughal (The Prince))",
        url = "https://youtube.com/@armughal431"
      )
      CbaLink(
        label = "YouTube Channel (Code and Big Apple)",
        url = "https://youtube.com/@multidev134"
      )
      Spacer(Modifier.height(10.dp))
      CbaClickableView(
        text = "What's new",
        onClick = {
          backStack.add(NavRoutes.WhatsNew)
        })
      Spacer(Modifier.height(10.dp))
      CbaClickableView(
        text = "Share app",
        onClick = {
          shareText(context, "https://github.com/armughal189/cba-link-saver/releases/download/latest/link-saver.apk")
        })
    }
  }
}

package io.multidev134.link_saver.features.about.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.multidev134.reuse_hub.ui.widget.CbaColumn
import io.multidev134.reuse_hub.ui.widget.CbaLayout
import io.multidev134.reuse_hub.ui.widget.CbaLink
import io.multidev134.reuse_hub.ui.widget.CbaTextView

@Composable
fun AboutScreen() {
  CbaLayout("About") {
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
        url = "mailto:armughal189@gmail.com"
      )
      CbaLink(
        label = "GitHub",
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
    }
  }
}

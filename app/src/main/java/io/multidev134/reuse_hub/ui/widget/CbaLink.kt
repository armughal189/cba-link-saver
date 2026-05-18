package io.multidev134.reuse_hub.ui.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import io.multidev134.reuse_hub.utils.openUrl

@Composable
fun CbaLink(
  label: String,
  url: String
) {
  val context = LocalContext.current
  CbaClickableView(
    text = label,
    onClick = {
      openUrl(context, url)
    })
}
package io.multidev134.link_saver.features.link_details.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.database.entities.LinkEntity
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.features.delete_link.ui.DeleteLinkDlg
import io.multidev134.reuse_hub.ui.widget.CbaButton
import io.multidev134.reuse_hub.ui.widget.CbaColumn
import io.multidev134.reuse_hub.ui.widget.CbaLayout
import io.multidev134.reuse_hub.ui.widget.CbaTextView
import io.multidev134.reuse_hub.utils.copyToClipboard
import io.multidev134.reuse_hub.utils.openUrl
import io.multidev134.reuse_hub.utils.shareText

@Composable
fun LinkDetailsScreen(
  link: LinkEntity
) {
  val backStack = LocalBackStack.current
  val context = LocalContext.current
  var isShowingDeleteDlg by rememberSaveable { mutableStateOf(false) }

  CbaLayout(
    title = "Link Info",
    onBackPress = {
      backStack.removeLastOrNull()
    }) {
    CbaColumn {
      CbaTextView(link.title, modifier = Modifier.fillMaxWidth())
      CbaTextView(link.desc, modifier = Modifier.fillMaxWidth())
      CbaTextView(link.url, modifier = Modifier.fillMaxWidth())
      CbaButton(
        label = "Open Link",
        onClick = {
          openUrl(context, link.url)
        },
        modifier = Modifier.fillMaxWidth()
      )
      CbaButton(
        label = "Copy to Clipboard",
        onClick = {
          copyToClipboard(context, link.url)
        },
        modifier = Modifier.fillMaxWidth()
      )
      CbaButton(
        label = "Share Link",
        onClick = {
          shareText(context, link.url)
        },
        modifier = Modifier.fillMaxWidth()
      )
      CbaButton(
        label = "Update Link",
        onClick = {
          backStack.add(NavRoutes.UpdateLink(link))
        },
        modifier = Modifier.fillMaxWidth()
      )
      CbaButton(
        label = "Delete Link",
        onClick = {
          isShowingDeleteDlg = true
        },
        modifier = Modifier.fillMaxWidth()
      )
    }
  }

  DeleteLinkDlg(
    isShowing = isShowingDeleteDlg,
    link = link,
    onDismiss = {
      isShowingDeleteDlg = false
    }
  )
}
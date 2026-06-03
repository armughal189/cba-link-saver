package io.multidev134.link_saver.features.link_details.ui

import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.database.LinkEntity
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.link_saver.features.delete_link.ui.deleteLinkDlg
import io.multidev134.link_saver.features.share_link.ui.shareLinkDlg
import io.multidev134.link_saver.features.update_link.ui.updateLinkDlg
import io.multidev134.reuse_hub.ui.widget.CbaButton
import io.multidev134.reuse_hub.ui.widget.CbaColumn
import io.multidev134.reuse_hub.ui.widget.CbaLayout
import io.multidev134.reuse_hub.ui.widget.CbaTextView
import io.multidev134.reuse_hub.utils.copyToClipboard
import io.multidev134.reuse_hub.utils.openUrl
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LinkDetailsScreen(
  link: LinkEntity,
  vm: LinksVM = koinViewModel()
) {
  val backStack = LocalBackStack.current
  val context = LocalContext.current
  val view = LocalView.current as ViewGroup
  val url = if (link.url.length >= 50) {
    link.url.substring(0, 50) + "..."
  } else {
    link.url
  }

  CbaLayout(
    title = "Link Info",
    onBackPress = {
      backStack.removeLastOrNull()
    }) {
    CbaColumn {
      CbaTextView(link.title, modifier = Modifier.fillMaxWidth())
      CbaTextView(link.desc, modifier = Modifier.fillMaxWidth())
      CbaTextView(url, modifier = Modifier.fillMaxWidth())
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
          view.shareLinkDlg(link)
        },
        modifier = Modifier.fillMaxWidth()
      )
      CbaButton(
        label = "Update Link",
        onClick = {
          view.updateLinkDlg(vm, link)
        },
        modifier = Modifier.fillMaxWidth()
      )
      CbaButton(
        label = "Delete Link",
        onClick = {
          view.deleteLinkDlg(vm, link, backStack)
        },
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}
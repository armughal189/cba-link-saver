package io.multidev134.link_saver.features.links_list.ui

import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.link_saver.features.delete_link.ui.deleteLinkDlg
import io.multidev134.link_saver.features.update_link.ui.updateLinkDlg
import io.multidev134.reuse_hub.ui.widget.CbaClickableView
import io.multidev134.reuse_hub.ui.widget.CbaLayout
import io.multidev134.reuse_hub.ui.widget.CbaTextView
import io.multidev134.reuse_hub.utils.copyToClipboard
import io.multidev134.reuse_hub.utils.openUrl
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LinksListScreen(
  vm: LinksVM = koinViewModel()
) {
  val backStack = LocalBackStack.current
  val allLinks by vm.allLinks.collectAsStateWithLifecycle(emptyList())
  val view = LocalView.current as ViewGroup
  val context = LocalContext.current
  CbaLayout("Links") {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Top,
      modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
    ) {
      if (allLinks.isEmpty()) {
        Box(
          modifier = Modifier.weight(1f),
          contentAlignment = Alignment.Center
        ) {
          CbaTextView(
            text = "You have No Links Right now. Get Started by Creating your First Link",
            modifier = Modifier.fillMaxWidth()
          )
        }
      } else {
        LazyColumn(
          modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
        ) {
          items(allLinks) { link ->
            CbaClickableView(
              text = "${link.title} - ${link.desc}",
              onClick = {
                backStack.add(NavRoutes.LinkDetails(link))
              },
              modifier = Modifier
                .fillMaxWidth()
                .semantics {
                  customActions = listOf(
                    CustomAccessibilityAction("Open Link") {
                      openUrl(context, link.url)
                      true
                    },
                    CustomAccessibilityAction("Copy link to Clipboard") {
                      copyToClipboard(context, link.url)
                      true
                    },
                    CustomAccessibilityAction("Update Link") {
                      view.updateLinkDlg(vm, link)
                      true
                    },
                    CustomAccessibilityAction("Delete Link") {
                      view.deleteLinkDlg(vm, link, backStack)
                      true
                    })
                })
          }
        }
      }
      CreateLinkBtn(vm)
    }
  }
}

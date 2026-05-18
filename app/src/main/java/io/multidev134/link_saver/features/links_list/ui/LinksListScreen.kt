package io.multidev134.link_saver.features.links_list.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.database.LinkEntity
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.link_saver.features.delete_link.ui.DeleteLinkDlg
import io.multidev134.reuse_hub.ui.widget.CbaClickableView
import io.multidev134.reuse_hub.ui.widget.CbaContextMenu
import io.multidev134.reuse_hub.ui.widget.CbaLayout
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LinksListScreen(
  vm: LinksVM = koinViewModel()
) {
  val backStack = LocalBackStack.current
  val allLinks by vm.allLinks.collectAsStateWithLifecycle(emptyList())
  var selectedLinkForMenu by rememberSaveable { mutableStateOf<LinkEntity?>(null) }
  var linkToDelete by rememberSaveable { mutableStateOf<LinkEntity?>(null) }
  val options = listOf(ContextMenuOptions.EDIT, ContextMenuOptions.DELETE)

  CbaLayout("Links") {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(18.dp)
    ) {
      Box(modifier = Modifier.weight(1f)) {
        if (allLinks.isEmpty()) {
          NoLinksUi()
        } else {
          LazyColumn(
            modifier = Modifier.fillMaxSize()
          ) {
            items(allLinks) { link ->
              Box {
                CbaClickableView(
                  text = "${link.id} - ${link.title} - ${link.desc}",
                  onClick = {
                    backStack.add(NavRoutes.LinkDetails(link))
                  },
                  onLongClick = {
                    selectedLinkForMenu = link
                  })
                
                CbaContextMenu(
                  isExpanded = selectedLinkForMenu == link,
                  onDismiss = {
                    selectedLinkForMenu = null
                  },
                  options = options,
                  onOptionSelected = { option ->
                    selectedLinkForMenu = null
                    when (option) {
                      ContextMenuOptions.EDIT -> {
                        backStack.add(NavRoutes.UpdateLink(link))
                      }
                      ContextMenuOptions.DELETE -> {
                        linkToDelete = link
                      }
                    }
                  })
              }
            }
          }
        }
      }
      CreateLinkBtn()
    }
  }

  linkToDelete?.let { link ->
    DeleteLinkDlg(
      isShowing = true,
      link = link,
      onDismiss = { linkToDelete = null },
      shouldNavigateBack = false
    )
  }
}
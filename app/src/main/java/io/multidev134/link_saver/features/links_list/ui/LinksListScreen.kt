package io.multidev134.link_saver.features.links_list.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.reuse_hub.ui.widget.CbaLayout
import io.multidev134.reuse_hub.ui.widget.CbaTextView
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LinksListScreen(
  vm: LinksVM = koinViewModel()
) {
  val backStack = LocalBackStack.current
  val allLinks by vm.allLinks.collectAsStateWithLifecycle(emptyList())
  CbaLayout("Links") {
    if (allLinks.isEmpty()) {
      NoLinksUi()
    } else {
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(18.dp)
      ) {
        items(allLinks) {
          CbaTextView("${it.id} - ${it.title} - ${it.desc}")
        }
      }
    }
  }
}
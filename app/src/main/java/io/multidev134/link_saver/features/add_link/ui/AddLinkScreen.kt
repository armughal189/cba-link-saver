package io.multidev134.link_saver.features.add_link.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.database.LinkEntity
import io.multidev134.link_saver.core.utils.validateUrl
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.reuse_hub.ui.widget.CbaButton
import io.multidev134.reuse_hub.ui.widget.CbaColumn
import io.multidev134.reuse_hub.ui.widget.CbaLayout
import io.multidev134.reuse_hub.ui.widget.CbaTextField
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddLinkScreen(
  vm: LinksVM = koinViewModel()
) {
  val backStack = LocalBackStack.current
  var title by rememberSaveable { mutableStateOf("") }
  var desc by rememberSaveable { mutableStateOf("") }
  var url by rememberSaveable { mutableStateOf("") }

  CbaLayout(
    title = "Add Link",
    onBackPress = { backStack.removeLastOrNull() }
  ) {
    CbaColumn {
      CbaTextField(
        label = "Title",
        value = title,
        onValueChange = { title = it }
      )
      CbaTextField(
        label = "Description",
        value = desc,
        onValueChange = { desc = it }
      )
      CbaTextField(
        label = "URL",
        value = url,
        onValueChange = { url = it },
        keyboardType = KeyboardType.Uri
      )
      CbaButton(
        label = "Save Link",
        enabled = title.isNotBlank() && url.isNotBlank(),
        onClick = {
          vm.addLink(
            LinkEntity(
              title = title.trim(),
              desc = desc.trim().ifEmpty {
                "No Description Provided"
              },
              url = validateUrl(url.trim())
            )
          )
          backStack.removeLastOrNull()
        },
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}

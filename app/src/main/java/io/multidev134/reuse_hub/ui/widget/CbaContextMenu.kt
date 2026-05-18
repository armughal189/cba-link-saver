package io.multidev134.reuse_hub.ui.widget

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import io.multidev134.link_saver.features.links_list.ui.ContextMenuOptions

@Composable
fun CbaContextMenu(
  isExpanded: Boolean,
  onDismiss: () -> Unit,
  options: List<ContextMenuOptions>,
  onOptionSelected: (ContextMenuOptions) -> Unit
) {
  if (isExpanded) {
    DropdownMenu(
      expanded = isExpanded,
      onDismissRequest = onDismiss
    ) {
      options.forEach {
        DropdownMenuItem(
          text = {
            CbaTextView(it.toString())
          },
          onClick = {
            onOptionSelected(it)
          })
      }
    }
  }
}
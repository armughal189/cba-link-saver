package io.multidev134.reuse_hub.ui.widget.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics

@Composable
fun CbaCheckBox(
  label: String,
  isChecked: Boolean,
  onCheckChange: (Boolean) -> Unit
) {
  Row(
    horizontalArrangement = Arrangement.Start,
    modifier = Modifier
      .fillMaxWidth()
      .semantics(mergeDescendants = true) {}
  ) {
    CbaTextView(
      text = label,
      modifier = Modifier
        .toggleable(
          value = isChecked,
          role = Role.Checkbox,
          onValueChange = onCheckChange
        )
        .weight(1f)
    )
    Checkbox(
      checked = isChecked,
      onCheckedChange = onCheckChange,
      modifier = Modifier.clearAndSetSemantics {}
    )
  }
}
package io.multidev134.reuse_hub.ui.widget.base

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun CbaDropDownMenu(
  label: String,
  options: List<String>,
  selectedOption: String = "",
  onOptionSelected: (String) -> Unit
) {
  var expanded by rememberSaveable { mutableStateOf(false) }

  Box(
    modifier = Modifier
      .fillMaxWidth()
      .clickable(
        onClick = { expanded = !expanded }
      )
      .semantics {
        contentDescription = label
        role = Role.DropdownList
      }) {
    CbaTextView(selectedOption)
    DropdownMenu(
      expanded = expanded,
      onDismissRequest = { expanded = false },
      modifier = Modifier.fillMaxWidth().heightIn(max = 240.dp)
    ) {
      options.forEach { option ->
        DropdownMenuItem(
          text = { CbaTextView(option) },
          onClick = {
            onOptionSelected(option)
            expanded = false
          })
      }
    }
  }
}

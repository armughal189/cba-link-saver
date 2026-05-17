package io.multidev134.reuse_hub.ui.widget

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CbaTextField(
  label: String,
  value: String,
  onValueChange: (String) -> Unit,
  keyboardType: KeyboardType = KeyboardType.Text,
  @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.fillMaxWidth()
) {
  TextField(
    value = value,
    onValueChange = onValueChange,
    label = { CbaTextView(label) },
    keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
    modifier = modifier
  )
}

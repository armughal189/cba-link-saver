package io.multidev134.reuse_hub.ui.widget.base

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import io.multidev134.reuse_hub.ui.widget.layout.CbaSpacer

@Composable
fun CbaTextField(
  label: String,
  value: String,
  onValueChange: (String) -> Unit,
  keyboardType: KeyboardType = KeyboardType.Text,
  isError: Boolean = false,
  errorText: String? = null,
  @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.fillMaxWidth()
) {
  Column(modifier = modifier) {
    CbaTextView(text = label)
    CbaSpacer(spacing = 4)
    TextField(
      value = value,
      onValueChange = onValueChange,
      isError = isError,
      supportingText = if (isError && !errorText.isNullOrEmpty()) {
        { CbaTextView(text = errorText) }
      } else null,
      keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
      modifier = Modifier.fillMaxWidth()
    )
  }
}

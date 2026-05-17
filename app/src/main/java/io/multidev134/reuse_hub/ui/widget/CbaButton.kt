package io.multidev134.reuse_hub.ui.widget

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CbaButton(
  label: String,
  onClick: () -> Unit,
  @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.fillMaxWidth(),
  enabled: Boolean = true
) {
  Button(onClick = {
    onClick()
  },
    enabled = enabled,
    modifier = modifier
  ) {
    CbaTextView(label)
  }
}
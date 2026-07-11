package io.multidev134.reuse_hub.ui.widget.layout

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CbaSpacer(spacing: Int = 8) {
  Spacer(modifier = Modifier.height(spacing.dp))
}

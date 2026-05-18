package io.multidev134.reuse_hub.ui.widget

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CbaClickableView(
  text: String,
  onClick: () -> Unit,
  onLongClick: (() -> Unit)? = null,
  @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.fillMaxWidth()
) {
  CbaTextView(
    text = text,
    modifier = modifier.combinedClickable(
      onClick = onClick,
      onLongClick = onLongClick
    )
  )
}

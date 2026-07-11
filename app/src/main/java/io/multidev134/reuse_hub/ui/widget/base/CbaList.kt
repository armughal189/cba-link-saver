package io.multidev134.reuse_hub.ui.widget.base

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun <T> CbaList(
  items: List<T>,
  @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.fillMaxSize(),
  content: @Composable (T) -> Unit
) {
  LazyColumn(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween,
    modifier = modifier
  ) {
    items(items) { item ->
      content(item)
    }
  }
}
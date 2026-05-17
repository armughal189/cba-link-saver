package io.multidev134.reuse_hub.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CbaLayout(
  title: String,
  content: @Composable () -> Unit
) {
  Scaffold(
    topBar = {
      TopAppBar(title = {
        CbaTextView(
          text = title,
          isHeading = true
        )
      })
    },
    modifier = Modifier
      .fillMaxSize()
      .semantics {
        paneTitle = title
      }) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      content()
    }
  }
}

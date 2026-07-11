package io.multidev134.reuse_hub.ui.widget.layout

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
import io.multidev134.reuse_hub.ui.widget.base.CbaButton
import io.multidev134.reuse_hub.ui.widget.base.CbaTextView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CbaLayout(
  title: String,
  onBackPress: (() -> Unit)? = null,
  content: @Composable () -> Unit
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          CbaTextView(
            text = title,
            isHeading = true,
            modifier = Modifier
          )
        },
        navigationIcon = {
          if (onBackPress != null) {
            CbaButton(
              label = "Back",
              onClick = onBackPress,
              modifier = Modifier
            )
          }
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
      CbaColumn { content() }
    }
  }
}

package io.multidev134.reuse_hub.ui.widget

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CbaAlertDialog(
  isShowing: Boolean,
  title: String,
  message: String,
  onNegativeBtnClick: () -> Unit,
  onPositiveBtnClick: () -> Unit,
  negativeBtnText: String = "No",
  positiveBtnText: String = "Yes"
) {
  if (isShowing) {
    AlertDialog(
      onDismissRequest = onNegativeBtnClick,
      title = {
        CbaTextView(
          text = title,
          isHeading = true
        )
      },
      text = {
        CbaTextView(text = message)
      },
      confirmButton = {
        TextButton(onClick = onPositiveBtnClick) {
          CbaTextView(
            text = positiveBtnText,
            modifier = Modifier
          )
        }
      },
      dismissButton = {
        TextButton(onClick = onNegativeBtnClick) {
          CbaTextView(
            text = negativeBtnText,
            modifier = Modifier
          )
        }
      }
    )
  }
}

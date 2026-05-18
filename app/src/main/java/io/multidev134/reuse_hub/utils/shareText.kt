package io.multidev134.reuse_hub.utils

import android.content.Context
import android.content.Intent

fun shareText(
  context: Context,
  text: String
) {
  val sendIntent: Intent = Intent().apply {
    action = Intent.ACTION_SEND
    putExtra(Intent.EXTRA_TEXT, text)
    type = "text/plain"
  }

  val shareIntent = Intent.createChooser(sendIntent, null)
  context.startActivity(shareIntent)
}

package io.multidev134.reuse_hub.ui.widget

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CbaTextView(
  text: String,
  @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.fillMaxWidth(),
  isHeading: Boolean = false,
  level: Int = 1
) {
  var updateModifier = modifier
  var fontSize = 16.sp
  var fontWeight = FontWeight.Normal
  if (isHeading) {
    fontSize = when (level) {
      1 -> 16.sp
      2 -> 18.sp
      else -> 24.sp
    }
    fontWeight = FontWeight.Bold
    updateModifier = updateModifier.semantics { heading() }
  }
  Text(
    text = text,
    fontFamily = FontFamily.SansSerif,
    fontSize = fontSize,
    fontWeight = fontWeight,
    modifier = updateModifier
  )
}
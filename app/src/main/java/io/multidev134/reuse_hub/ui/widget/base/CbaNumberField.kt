package io.multidev134.reuse_hub.ui.widget.base

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CbaNumberField(
  label: String,
  value: String,
  onValueChange: (String) -> Unit,
  minLength: Int? = null,
  maxLength: Int? = null,
  errorText: String? = null,
  @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.fillMaxWidth()
) {
  val isError = minLength != null && value.isNotEmpty() && value.length < minLength
  val resolvedErrorText = errorText ?: if (isError) "Must be at least $minLength digits" else null

  CbaTextField(
    label = label,
    value = value,
    onValueChange = { newValue ->
      val digitsOnly = newValue.filter { it.isDigit() }
      if (maxLength == null || digitsOnly.length <= maxLength) {
        onValueChange(digitsOnly)
      }
    },
    keyboardType = KeyboardType.Number,
    isError = isError || !errorText.isNullOrEmpty(),
    errorText = resolvedErrorText,
    modifier = modifier
  )
}

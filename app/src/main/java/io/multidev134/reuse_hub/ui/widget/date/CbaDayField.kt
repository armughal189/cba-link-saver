package io.multidev134.reuse_hub.ui.widget.date

import androidx.compose.runtime.Composable
import io.multidev134.reuse_hub.ui.widget.base.CbaNumberField

@Composable
fun CbaDayField(
  selectedDay: Int,
  onDaySelected: (Int) -> Unit
) {
  val isError = selectedDay != 0 && selectedDay !in 1..31
  CbaNumberField(
    label = "Day:",
    value = if (selectedDay == 0) "" else selectedDay.toString(),
    onValueChange = { input ->
      onDaySelected(input.toIntOrNull() ?: 0)
    },
    maxLength = 2,
    errorText = if (isError) "Day must be between 1 and 31" else null
  )
}

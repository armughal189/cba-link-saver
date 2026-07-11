package io.multidev134.reuse_hub.ui.widget.date

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import io.multidev134.reuse_hub.ui.widget.base.CbaNumberField

@Composable
fun CbaMonthField(
  selectedMonth: String = "",
  onMonthSelected: (String) -> Unit
) {
  val months = listOf(
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"
  )
  val initialMonthNumber = if (selectedMonth.isNotEmpty()) months.indexOf(selectedMonth) + 1 else 0
  val initialText = if (initialMonthNumber == 0) "" else initialMonthNumber.toString()

  var textState by rememberSaveable(selectedMonth) { mutableStateOf(initialText) }

  val num = textState.toIntOrNull()
  val isError = textState.isNotEmpty() && (num == null || num !in 1..12)

  CbaNumberField(
    label = "Month:",
    value = textState,
    onValueChange = { input ->
      textState = input
      val parsedNum = input.toIntOrNull()
      if (parsedNum != null && parsedNum in 1..12) {
        onMonthSelected(months[parsedNum - 1])
      } else {
        onMonthSelected("")
      }
    },
    maxLength = 2,
    errorText = if (isError) "Month must be between 1 and 12" else null
  )
}

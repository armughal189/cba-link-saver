package io.multidev134.reuse_hub.ui.widget.date

import androidx.compose.runtime.Composable
import io.multidev134.reuse_hub.ui.widget.base.CbaNumberField
import java.util.Calendar

@Composable
fun CbaYearField(
  selectedYear: Int,
  startYear: Int = 1900,
  endYear: Int = Calendar.getInstance().get(Calendar.YEAR),
  onYearSelected: (Int) -> Unit
) {
  val isError = selectedYear != 0 && selectedYear.toString().length == 4 && selectedYear !in startYear..endYear
  CbaNumberField(
    label = "Year:",
    value = if (selectedYear == 0) "" else selectedYear.toString(),
    onValueChange = { input ->
      onYearSelected(input.toIntOrNull() ?: 0)
    },
    maxLength = 4,
    errorText = if (isError) "Year must be between $startYear and $endYear" else null
  )
}

package io.multidev134.reuse_hub.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun formatDate(date: LocalDate): String {
  val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
  return date.format(formatter)
}
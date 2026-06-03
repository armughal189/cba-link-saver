package io.multidev134.reuse_hub.utils

fun validateUrl(url: String): String {
  var finalUrl = url.trim()
  if (finalUrl.isEmpty()) return ""

  if (!finalUrl.startsWith("http://", ignoreCase = true) &&
    !finalUrl.startsWith("https://", ignoreCase = true)
  ) {
    finalUrl = "https://$finalUrl"
  }
  return finalUrl.replace(" ", "%20")
}

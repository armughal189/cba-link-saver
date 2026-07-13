package io.multidev134.link_saver.features.auth

fun validatePassword(password: String): String {
  return when {
    password.isNotEmpty() && password.length < 8 ->
      "Password should have at least 8 Characters"
    password.length > 20 ->
      "Password should not go above 20 Characters"
    else -> ""
  }
}

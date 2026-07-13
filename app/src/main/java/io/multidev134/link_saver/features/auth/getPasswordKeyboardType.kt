package io.multidev134.link_saver.features.auth

import androidx.compose.ui.text.input.KeyboardType

fun getPasswordKeyboardType(showPassword: Boolean): KeyboardType {
  return if (showPassword) {
    KeyboardType.Text
  } else {
    KeyboardType.Password
  }
}

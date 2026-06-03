package io.multidev134.link_saver.features.settings.ui

import androidx.appcompat.app.AppCompatDelegate

fun handleThemeMode(mode: String) {
  when (mode) {
    "system", "auto" -> {
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

    "lite", "light" -> {
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    "dark" -> {
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
  }
}

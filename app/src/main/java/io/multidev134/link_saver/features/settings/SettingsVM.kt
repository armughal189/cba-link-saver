package io.multidev134.link_saver.features.settings

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.preference.PreferenceManager
import io.multidev134.link_saver.core.database.LinkDao
import io.multidev134.link_saver.features.settings.ui.handleThemeMode
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel
import androidx.core.content.edit

@KoinViewModel
class SettingsVM(
  context: Context,
  private val dao: LinkDao
) : ViewModel() {
  private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

  var themeMode by mutableStateOf(prefs.getString("theme_mode", "system") ?: "system")
    private set

  fun setThemeMode(newThemeMode: String) {
    themeMode = newThemeMode
    prefs.edit { putString("theme_mode", newThemeMode) }
    handleThemeMode(newThemeMode)
  }

  fun clearDb() {
    viewModelScope.launch {
      dao.clearLinks()
    }
  }
}

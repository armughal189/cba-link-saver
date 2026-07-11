package io.multidev134.link_saver.features.settings.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.preference.PreferenceManager
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.reuse_hub.ui.widget.base.CbaClickableView
import io.multidev134.reuse_hub.ui.widget.base.CbaDropDownMenu
import io.multidev134.reuse_hub.ui.widget.base.CbaTextView
import io.multidev134.reuse_hub.ui.widget.layout.CbaLayout
import io.multidev134.reuse_hub.ui.widget.layout.CbaSpacer
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SettingsScreen(
  vm: LinksVM = koinViewModel()
) {
  val context = LocalContext.current
  val prefs = PreferenceManager.getDefaultSharedPreferences(context)

  var themeMode by rememberSaveable {
    mutableStateOf(prefs.getString("theme_mode", "system") ?: "system")
  }

  val themeOptions = listOf("System Default", "Auto", "Dark", "Lite")
  val themeValues = listOf("system", "auto", "dark", "lite")

  val selectedEntryName = when (themeMode) {
    "system" -> "System Default"
    "auto" -> "Auto"
    "dark" -> "Dark"
    "lite" -> "Lite"
    else -> "System Default"
  }

  CbaLayout("Settings") {
    LazyColumn(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      item {
        CbaTextView("General", isHeading = true, level = 2)
        CbaSpacer(8)
      }

      item {
        CbaDropDownMenu(
          label = "Theme",
          options = themeOptions,
          selectedOption = selectedEntryName,
          onOptionSelected = { selectedLabel ->
            val index = themeOptions.indexOf(selectedLabel)
            if (index != -1) {
              val newValue = themeValues[index]
              themeMode = newValue
              prefs.edit().putString("theme_mode", newValue).apply()
              handleThemeMode(newValue)
            }
          }
        )
        CbaSpacer(16)
      }

      item {
        CbaTextView("Danger Zone", isHeading = true, level = 1)
        CbaSpacer(8)
      }

      item {
        CbaClickableView(
          text = "Clear Database",
          onClick = {
            context.clearDb(vm)
          }
        )
      }
    }
  }
}

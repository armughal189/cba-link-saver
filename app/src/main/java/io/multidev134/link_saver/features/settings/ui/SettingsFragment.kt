package io.multidev134.link_saver.features.settings.ui

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import io.multidev134.link_saver.R
import io.multidev134.link_saver.core.view_models.LinksVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : PreferenceFragmentCompat() {
  private val vm: LinksVM by viewModel()
  override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
    setPreferencesFromResource(R.xml.root_preferences, rootKey)
    val clearDb = findPreference<Preference>("clear_db")
    val themeMode = findPreference<ListPreference>("theme_mode")
    clearDb?.setOnPreferenceClickListener {
      requireContext()
        .clearDb(vm)
      true
    }
    themeMode?.setOnPreferenceChangeListener { _, newValue ->
      handleThemeMode(newValue as String)
      true
    }
  }
}

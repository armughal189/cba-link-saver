package io.multidev134.link_saver.features.settings.ui

import android.view.View
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import io.multidev134.reuse_hub.ui.widget.CbaLayout

@Composable
fun SettingsScreen() {
  val activity = LocalActivity.current as FragmentActivity
  CbaLayout("Settings") {
    AndroidView(factory = { context ->
      FragmentContainerView(context).apply {
        id = View.generateViewId()
        activity.supportFragmentManager.beginTransaction()
          .replace(id, SettingsFragment())
          .commit()
      }

    })

  }
}

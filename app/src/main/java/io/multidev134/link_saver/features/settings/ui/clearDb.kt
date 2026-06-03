package io.multidev134.link_saver.features.settings.ui

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.reuse_hub.utils.toast

fun Context.clearDb(
  vm: LinksVM
) {
  MaterialAlertDialogBuilder(this)
    .setTitle("Clear Database")
    .setMessage("Clicking Yes will Delete your Entire Links Data Which can't be recovered. Are you sure you want to Clear your Database?")
    .setNegativeButton("No", null)
    .setPositiveButton("Yes") { _, _ ->
      vm.clearDb()
      toast(this, "The Database has been cleared successfully")
    }
    .show()
}


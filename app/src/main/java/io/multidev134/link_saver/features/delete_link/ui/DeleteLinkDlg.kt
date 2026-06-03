package io.multidev134.link_saver.features.delete_link.ui

import android.view.ViewGroup
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import io.multidev134.link_saver.core.database.LinkEntity
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.core.view_models.LinksVM

fun ViewGroup.deleteLinkDlg(
  vm: LinksVM,
  link: LinkEntity,
  backStack: NavBackStack<NavKey>
) {
  MaterialAlertDialogBuilder(this.context)
    .setTitle("Delete Link")
    .setMessage("Are you sure you want to delete '${link.title}'?")
    .setPositiveButton("Delete") { _, _ ->
      vm.deleteLink(link)
      if (backStack.last() is NavRoutes.LinkDetails) {
        backStack.removeLastOrNull()
      }
    }
    .setNegativeButton("Cancel", null)
    .show()
}

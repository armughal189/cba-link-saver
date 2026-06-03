package io.multidev134.link_saver.features.share_link.ui

import android.view.ViewGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import io.multidev134.link_saver.core.database.LinkEntity
import io.multidev134.reuse_hub.utils.shareText

fun ViewGroup.shareLinkDlg(
  link: LinkEntity
) {
  val items = arrayOf("Share with Title Included", "Share just URL")
  MaterialAlertDialogBuilder(context)
    .setTitle("Share Link")
    .setItems(items) { _, which ->
      when (which) {
        0 -> shareText(context, "${link.title}:\n${link.url}")
        1 -> shareText(context, link.url)
      }
    }
    .setNegativeButton("Cancel", null)
    .show()
}

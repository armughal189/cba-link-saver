package io.multidev134.link_saver.features.add_link.ui

import android.text.InputType
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import io.multidev134.link_saver.R
import io.multidev134.link_saver.core.database.LinkEntity
import io.multidev134.reuse_hub.utils.validateUrl
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.reuse_hub.ui.widget.legacy.cbaXTextField
import io.multidev134.reuse_hub.utils.inflateLayout

fun ViewGroup.addLinkDlg(
  vm: LinksVM
) {
  val container = inflateLayout(context, this, R.layout.empty_layout, false) as LinearLayout

  var title = ""
  var desc = ""
  var url = ""

  container.cbaXTextField(
    hint = "Title",
    onTextChanged = { title = it }
  )

  container.cbaXTextField(
    hint = "Description (Optional)",
    onTextChanged = { desc = it },
    inputType = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
  )

  container.cbaXTextField(
    hint = "URL",
    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_URI,
    onTextChanged = { url = it }
  )

  MaterialAlertDialogBuilder(context)
    .setTitle("Add New Link")
    .setView(container)
    .setPositiveButton("Save") { _, _ ->
      val validatedUrl = validateUrl(url)
      if (title.isNotBlank() && validatedUrl.isNotBlank()) {
        vm.addLink(
          LinkEntity(
            title = title,
            desc = desc,
            url = validatedUrl
          )
        )
      }
    }
    .setNegativeButton("Cancel", null)
    .show()
}

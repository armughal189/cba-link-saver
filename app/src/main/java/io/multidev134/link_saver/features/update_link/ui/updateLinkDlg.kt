package io.multidev134.link_saver.features.update_link.ui

import android.text.InputType
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import io.multidev134.link_saver.R
import io.multidev134.link_saver.core.database.LinkEntity
import io.multidev134.reuse_hub.utils.validateUrl
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.reuse_hub.ui.widget.cbaXTextField
import io.multidev134.reuse_hub.utils.inflateLayout

fun ViewGroup.updateLinkDlg(
  vm: LinksVM,
  link: LinkEntity
) {
  val container = inflateLayout(context, LinearLayout(context), R.layout.empty_layout, false) as LinearLayout

  var title = link.title
  var desc = link.desc
  var url = link.url

  container.cbaXTextField(
    hint = "Title",
    text = title,
    onTextChanged = { title = it }
  )

  container.cbaXTextField(
    hint = "Description (Optional)",
    text = desc,
    onTextChanged = { desc = it },
    inputType = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
  )

  container.cbaXTextField(
    hint = "URL",
    text = url,
    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_URI,
    onTextChanged = { url = it }
  )

  MaterialAlertDialogBuilder(context)
    .setTitle("Update Link")
    .setView(container)
    .setPositiveButton("Update") { _, _ ->
      val validatedUrl = validateUrl(url)
      if (title.isNotBlank() && validatedUrl.isNotBlank()) {
        vm.modLink(
          link.copy(
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

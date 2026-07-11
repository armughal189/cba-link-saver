package io.multidev134.reuse_hub.ui.widget.legacy

import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import io.multidev134.reuse_hub.utils.matchParentWrapContent

fun ViewGroup.cbaXButton(
  label: String,
  onClick: () -> Unit
): MaterialButton {
  val view = MaterialButton(context).apply {
    layoutParams = matchParentWrapContent()
    text = label
    setOnClickListener {
      onClick()
    }
  }
  addView(view)
  return view
}

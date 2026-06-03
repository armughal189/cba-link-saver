package io.multidev134.reuse_hub.ui.widget

import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import io.multidev134.link_saver.R
import io.multidev134.reuse_hub.utils.inflateLayout

fun ViewGroup.cbaXButton(
  label: String,
  onClick: () -> Unit
): MaterialButton {
  val view = inflateLayout(context, this, R.layout.button, false) as MaterialButton
  view.text = label
  view.setOnClickListener {
    onClick()
  }
  addView(view)
  return view
}

package io.multidev134.reuse_hub.ui.widget.legacy

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import io.multidev134.reuse_hub.utils.matchParentMatchParent

fun ViewGroup.cbaXContainer(
  init: LinearLayout.() -> Unit
): LinearLayout {
  val container = LinearLayout(context).apply {
    layoutParams = matchParentMatchParent()
    orientation = LinearLayout.VERTICAL
    init()
  }
  addView(container)
  return container
}

fun cbaXContainer(
  context: Context,
  init: LinearLayout.() -> Unit
): LinearLayout {
  return LinearLayout(context).apply {
    layoutParams = matchParentMatchParent()
    orientation = LinearLayout.VERTICAL
    init()
  }
}

package io.multidev134.reuse_hub.utils

import android.view.ViewGroup
import android.widget.LinearLayout

fun matchParentWrapContent(): LinearLayout.LayoutParams {
  return LinearLayout.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT,
    ViewGroup.LayoutParams.WRAP_CONTENT
  )
}

fun matchParentMatchParent(): LinearLayout.LayoutParams {
  return LinearLayout.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT,
    ViewGroup.LayoutParams.MATCH_PARENT
  )
}


package io.multidev134.reuse_hub.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun inflateLayout(
  context: Context,
  parent: ViewGroup,
  resId: Int,
  addToParent: Boolean = true
): View {
  return LayoutInflater.from(context).inflate(resId, parent, addToParent)
}
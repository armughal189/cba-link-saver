package io.multidev134.link_saver.features.links_list.ui

enum class ContextMenuOptions {
  EDIT,
  DELETE;

  override fun toString(): String {
    return when(this) {
      EDIT -> "Edit"
      DELETE -> "Delete"
    }
  }
}
package io.multidev134.link_saver.core.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.multidev134.link_saver.core.database.daos.LinkDao
import io.multidev134.link_saver.core.database.entities.LinkEntity
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class LinksVM(
  private val dao: LinkDao
): ViewModel() {
  var allLinks = dao.getAll()
    private set
  fun addLink(link: LinkEntity) {
    viewModelScope.launch {
      dao.addLink(link)
    }
  }
  fun modLink(link: LinkEntity) {
    viewModelScope.launch {
      dao.modLink(link)
    }
  }

  fun deleteLink(link: LinkEntity) {
    viewModelScope.launch {
      dao.deleteLink(link)
    }
  }
}
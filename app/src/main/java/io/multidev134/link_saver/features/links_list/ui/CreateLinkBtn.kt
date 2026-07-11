package io.multidev134.link_saver.features.links_list.ui

import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.platform.LocalView
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.link_saver.features.add_link.ui.addLinkDlg
import io.multidev134.reuse_hub.ui.widget.base.CbaButton

@Composable
fun CreateLinkBtn(vm: LinksVM) {
  val view = LocalView.current as ViewGroup
  CbaButton(
    label = "Create a new Link",
    onClick = {
      view.addLinkDlg(vm)
    },
    modifier = Modifier.fillMaxWidth()
  )
}

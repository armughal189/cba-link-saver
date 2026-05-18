package io.multidev134.link_saver.features.delete_link.ui
import androidx.compose.runtime.Composable
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.link_saver.core.database.entities.LinkEntity
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.core.view_models.LinksVM
import io.multidev134.reuse_hub.ui.widget.CbaAlertDialog
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DeleteLinkDlg(
  isShowing: Boolean,
  link: LinkEntity,
  onDismiss: () -> Unit,
  shouldNavigateBack: Boolean = true,
  vm: LinksVM = koinViewModel()
) {
  val backStack = LocalBackStack.current
  CbaAlertDialog(
    isShowing = isShowing,
    title = "Delete Link",
    message = "Are you sure you want to delete '${link.title}'?",
    onNegativeBtnClick = onDismiss,
    onPositiveBtnClick = {
      vm.deleteLink(link)
      onDismiss()
      if (shouldNavigateBack) {
        backStack.removeLastOrNull()
      }
    }
  )
}

package io.multidev134.link_saver.features.whats_new

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.multidev134.link_saver.core.composition.LocalBackStack
import io.multidev134.reuse_hub.ui.widget.CbaColumn
import io.multidev134.reuse_hub.ui.widget.CbaLayout
import io.multidev134.reuse_hub.ui.widget.CbaTextView
import io.multidev134.reuse_hub.utils.formatDate
import java.time.LocalDate

@Composable
fun WhatsNewScreen() {
  val backStack = LocalBackStack.current
  CbaLayout(
    title = "What's New",
    onBackPress = { backStack.removeLastOrNull() }
  ) {
    CbaColumn {
      CbaTextView("Released On: ${formatDate(LocalDate.of(2026, 6, 7))}")
      Spacer(Modifier.height(12.dp))
      LazyColumn {
        item {
          CbaTextView("Fixed the Accessibility of TextBoxes with Jieshuo Screen Reader")
        }
        item {
          CbaTextView("Migrated to Views based Dialogs from Compose Dialogs for Accessibility.")
        }
        item {
          CbaTextView("Added the Ability to Customize What to Share when Sharing A Link. You can choose to share With Title Included or Just URL like before")
        }
        item {
          CbaTextView("Removed Context Menu and Added Accessibility Actions Instead, You can Open, Copy, Share, Update and Delete A Link with Accessibility Actions as well.")
        }
        item {
          CbaTextView("Renamed the About Tab to More. Now It also have Share App and What's New Options. Also, The email is changed.")
        }
        item {
          CbaTextView("Added Automatic Dark and Lite Mode Support.")
        }
        item {
          CbaTextView("Added a Settings Tab.")
        }
        item {
          CbaTextView("Available Options in Settings", isHeading = true)
        }
        item {
          CbaTextView("Theme Mode: You can also switch between System Default, Auto, Dark and Lite Theme Modes.")
        }
        item {
          CbaTextView("Clear Database: Clears the entire Database.")
        }
      }
    }
  }
}
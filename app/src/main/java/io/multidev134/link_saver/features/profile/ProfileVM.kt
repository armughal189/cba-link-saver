package io.multidev134.link_saver.features.profile

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.preference.PreferenceManager
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class ProfileVM(
  context: Context,
  private val client: SupabaseClient
) : ViewModel() {
  private val prefs = PreferenceManager.getDefaultSharedPreferences(context)
  var email by mutableStateOf(prefs.getString("user_email", "") ?: "")
    private set
  var displayName by mutableStateOf(prefs.getString("display_name", "") ?: "")
    private set
  fun signout(onSuccess: () -> Unit) {
    viewModelScope.launch {
      try {
        client.auth.signOut()
      } catch (_: Exception) {
        // Signout error handling
      } finally {
        prefs.edit().apply {
          remove("user_email")
          remove("display_name")
          apply()
        }
        onSuccess()
      }
    }
  }
}

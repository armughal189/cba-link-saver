package io.multidev134.link_saver.features.auth

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.preference.PreferenceManager
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class AuthVM(
  context: Context,
  private val client: SupabaseClient
) : ViewModel() {
  private val prefs = PreferenceManager.getDefaultSharedPreferences(context)
  var authState = mutableStateOf<AuthState>(AuthState.Idle)
    private set

  fun signup(email: String, password: String, displayName: String) {
    viewModelScope.launch {
      authState.value = AuthState.Loading
      try {
        val result = client.auth.signUpWith(Email) {
          this.email = email
          this.password = password
        }
        val userId = result?.id ?: client.auth.currentUserOrNull()?.id
        ?: throw Exception("Could not retrieve user ID.")
        val profile = Profile(id = userId, display_name = displayName)
        client.from("profiles").insert(profile)
        prefs.edit().apply {
          putString("user_email", email)
          putString("display_name", displayName)
          apply()
        }
        authState.value = AuthState.Success
      } catch (e: Exception) {
        authState.value = AuthState.Error(e.message ?: "Signup Failed because of unknown Reason.")
      }
    }
  }

  fun login(email: String, password: String) {
    viewModelScope.launch {
      authState.value = AuthState.Loading
      try {
        client.auth.signInWith(Email) {
          this.email = email
          this.password = password
        }
        val currentUser = client.auth.currentUserOrNull()
        if (currentUser != null) {
          val profile = client.from("profiles").select {
            filter {
              eq("id", currentUser.id)
            }
          }.decodeSingle<Profile>()
          prefs.edit().apply {
            putString("user_email", currentUser.email)
            putString("display_name", profile.display_name)
            apply()
          }
        }
        authState.value = AuthState.Success
      } catch (e: Exception) {
        authState.value = AuthState.Error(e.message ?: "Login Failed because of unknown Reason.")
      }
    }
  }

  fun resetState() {
    authState.value = AuthState.Idle
  }

  fun isLoggedIn(): Boolean {
    return !prefs.getString("user_email", null).isNullOrEmpty()
  }
}

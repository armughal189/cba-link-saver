package io.multidev134.link_saver.features.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class AuthVM(
  private val client: SupabaseClient
): ViewModel() {
  var authState = mutableStateOf<AuthState>(AuthState.Idle)
    private set
  fun signup(email: String, password: String) {
    viewModelScope.launch {
      authState.value = AuthState.Loading
      try {
        client.auth.signUpWith(Email) {
          this.email = email
          this.password = password
        }
        authState.value = AuthState.Success
      } catch (e: Exception) {
        authState.value = AuthState.Error(e.message ?: "Signup Failed because of unknown Reason.")
      } finally {
        resetState()
      }
    }
  }
  fun signout() {
    viewModelScope.launch {
      client.auth.signOut()
    }
  }
  fun resetState() {
    authState.value = AuthState.Idle
  }
}
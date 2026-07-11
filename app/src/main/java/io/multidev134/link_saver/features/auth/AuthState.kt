package io.multidev134.link_saver.features.auth

sealed interface AuthState {
  object Idle : AuthState
  object Loading : AuthState
  object Success : AuthState
  data class Error(val message: String) : AuthState
}
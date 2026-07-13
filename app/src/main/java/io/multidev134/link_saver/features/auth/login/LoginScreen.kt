package io.multidev134.link_saver.features.auth.login

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import io.multidev134.link_saver.core.navigation.LocalBackStack
import io.multidev134.link_saver.core.navigation.NavRoutes
import io.multidev134.link_saver.features.auth.AuthState
import io.multidev134.link_saver.features.auth.AuthVM
import io.multidev134.link_saver.features.auth.getPasswordKeyboardType
import io.multidev134.link_saver.features.auth.validatePassword
import io.multidev134.reuse_hub.ui.widget.base.CbaButton
import io.multidev134.reuse_hub.ui.widget.base.CbaCheckBox
import io.multidev134.reuse_hub.ui.widget.base.CbaTextField
import io.multidev134.reuse_hub.ui.widget.base.CbaTextView
import io.multidev134.reuse_hub.ui.widget.layout.CbaLayout
import io.multidev134.reuse_hub.utils.toast
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
  vm: AuthVM = koinViewModel()
) {
  val backStack = LocalBackStack.current
  val context = LocalContext.current
  val authState by vm.authState
  var email by rememberSaveable { mutableStateOf("") }
  var password by rememberSaveable { mutableStateOf("") }
  var showPassword by rememberSaveable { mutableStateOf(false) }

  val errorMsg = validatePassword(password)

  val canLogin = email.isNotEmpty() &&
      password.isNotEmpty() &&
      errorMsg.isEmpty() &&
      authState !is AuthState.Loading

  val passwordKeyboardType = getPasswordKeyboardType(showPassword)

  LaunchedEffect(authState) {
    when (val state = authState) {
      is AuthState.Success -> {
        toast(context, "Login Successful!")
        vm.resetState()
        backStack.clear()
        backStack.add(NavRoutes.Home)
      }
      is AuthState.Error -> {
        toast(context, state.message)
        vm.resetState()
      }
      else -> {}
    }
  }

  CbaLayout(
    title = "Login",
    onBackPress = {
      backStack.removeLastOrNull()
    }) {
    CbaTextView("Welcome Back! Login to your Account")
    CbaTextField(
      label = "Email:",
      value = email,
      onValueChange = { email = it },
      keyboardType = KeyboardType.Email
    )
    CbaTextField(
      label = "Password:",
      value = password,
      onValueChange = { password = it },
      keyboardType = passwordKeyboardType
    )
    CbaCheckBox(
      label = "Show Password",
      isChecked = showPassword,
      onCheckChange = { showPassword = it }
    )
    if (errorMsg.isNotEmpty()) {
      CbaTextView(errorMsg)
    }
    if (authState is AuthState.Loading) {
      CircularProgressIndicator()
    } else {
      CbaButton(
        label = "Login",
        enabled = canLogin,
        onClick = {
          vm.login(email, password)
        })
    }
  }
}

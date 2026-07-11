package io.multidev134.reuse_hub.ui.widget.legacy

import android.text.InputType
import android.view.ContextThemeWrapper
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import io.multidev134.reuse_hub.utils.matchParentWrapContent

fun ViewGroup.cbaXTextField(
  hint: String,
  text: String = "",
  inputType: Int = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS,
  onTextChanged: ((String) -> Unit)? = null,
): TextInputLayout {
  val contextThemeWrapper = ContextThemeWrapper(context, com.google.android.material.R.style.Widget_Material3_TextInputLayout_OutlinedBox)
  val view = TextInputLayout(contextThemeWrapper, null).apply {
    layoutParams = matchParentWrapContent()
    this.hint = hint
  }

  val editText = TextInputEditText(view.context).apply {
    layoutParams = matchParentWrapContent()
    setText(text)
    this.inputType = inputType
    onTextChanged?.let { callback ->
      doAfterTextChanged { callback(it?.toString() ?: "") }
    }
  }

  view.addView(editText)
  addView(view)
  return view
}

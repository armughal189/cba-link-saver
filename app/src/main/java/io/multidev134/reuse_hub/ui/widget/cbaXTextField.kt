package io.multidev134.reuse_hub.ui.widget

import android.text.InputType
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputLayout
import io.multidev134.link_saver.R
import io.multidev134.reuse_hub.utils.inflateLayout

fun ViewGroup.cbaXTextField(
  hint: String,
  text: String = "",
  inputType: Int = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS,
  onTextChanged: ((String) -> Unit)? = null,
): TextInputLayout {
  val view = inflateLayout(context, this, R.layout.text_field, false) as TextInputLayout
  view.hint = hint
  view.editText?.apply {
    setText(text)
    this.inputType = inputType
    onTextChanged?.let { callback ->
      doAfterTextChanged { callback(it?.toString() ?: "") }
    }
  }
  addView(view)
  return view
}

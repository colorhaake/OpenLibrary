package com.example.openlibrary.widget

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.core.Text
import androidx.ui.core.TextField
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.input.VisualTransformation
import androidx.ui.layout.Stack
import androidx.ui.text.TextStyle

@Composable
fun ExTextField(
    value: String,
    hintValue: String = "",
    modifier: Modifier = Modifier.None,
    onValueChange: (String) -> Unit = {},
    textStyle: TextStyle? = null,
    hintTextStyle: TextStyle? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Unspecified,
    onFocus: () -> Unit = {},
    onBlur: () -> Unit = {},
    focusIdentifier: String? = null,
    onImeActionPerformed: (ImeAction) -> Unit = {},
    visualTransformation: VisualTransformation? = null
) {
    val currentText = state { value }
    val onCurrentTextChanged = { text: String ->
        currentText.value = text
        onValueChange(text)
    }

    Stack {
        TextField(
            value = currentText.value,
            modifier = modifier,
            onValueChange = onCurrentTextChanged,
            textStyle = textStyle,
            keyboardType = keyboardType,
            imeAction = imeAction,
            onFocus = onFocus,
            onBlur = onBlur,
            focusIdentifier = focusIdentifier,
            onImeActionPerformed = onImeActionPerformed,
            visualTransformation = visualTransformation
        )

        if (currentText.value.isEmpty()) {
            Text(
                text = hintValue,
                modifier = modifier,
                style = hintTextStyle
            )
        }
    }
}

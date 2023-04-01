package com.mtali.tigopesa.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.core.ui.theme.LightBlue

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OtpView() {
    val (editValue, setEditValue) = remember { mutableStateOf("") }
    val otpLength = remember { 4 }
    val focusRequester = remember { FocusRequester() }
    var focused by remember { mutableStateOf(false) }
    val keyboard = LocalSoftwareKeyboardController.current

    TextField(
        value = editValue,
        onValueChange = {
            if (it.length <= otpLength) {
                setEditValue(it)
            }
        },
        modifier = Modifier
            .size(1.dp)
            .alpha(0f)
            .focusRequester(focusRequester)
            .onFocusChanged { state ->
                focused = state.isFocused
            },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )

    LaunchedEffect(Unit) { focusRequester.requestFocus() }

    Row {
        (0 until otpLength).map { index ->
            OtpCell(
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        focusRequester.requestFocus()
                        keyboard?.show()
                    },
                value = editValue.getOrNull(index)?.toString() ?: "",
                isActive = editValue.length == index && focused
            )
            Spacer(modifier = Modifier.size(10.dp))
        }
    }

}

@Composable
private fun OtpCell(
    modifier: Modifier,
    value: String,
    isActive: Boolean = false
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        TigoTextField(
            modifier = modifier,
            value = "",
            enabled = isActive
        )
        if (value.isNotBlank()) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(LightBlue)
            )
        }

    }
}
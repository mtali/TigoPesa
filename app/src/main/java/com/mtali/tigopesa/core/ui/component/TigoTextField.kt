package com.mtali.tigopesa.core.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.core.ui.theme.LightBlue

@Composable
fun TigoTextField(
    modifier: Modifier = Modifier,
    value: String,
    @StringRes title: Int? = null,
    onChangeValue: (String) -> Unit = {},
    enabled: Boolean = true,
    placeholder: Int? = null,
) {
    Column(modifier.fillMaxWidth()) {
        title?.let {
            Text(text = stringResource(id = title))
            Spacer(modifier = Modifier.height(8.dp))
        }


        OutlinedTextField(
            value = value,
            onValueChange = onChangeValue,
            enabled = enabled,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledBorderColor = LightBlue.copy(0.5f),
                textColor = LightBlue,
                disabledTextColor = LightBlue,
                focusedBorderColor = LightBlue,
                backgroundColor = LightBlue.copy(0.1f),
            ),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                placeholder?.let {
                    Text(text = stringResource(id = placeholder))
                }
            }
        )
    }
}

fun LazyListScope.tigoTextField(
    modifier: Modifier = Modifier,
    value: String,
    @StringRes title: Int? = null,
    onChangeValue: (String) -> Unit = {},
    enabled: Boolean = true,
    placeholder: Int? = null,
) {
    item {
        TigoTextField(
            modifier = modifier,
            value = value,
            title = title,
            onChangeValue = onChangeValue,
            enabled = enabled,
            placeholder = placeholder,
        )
    }
}
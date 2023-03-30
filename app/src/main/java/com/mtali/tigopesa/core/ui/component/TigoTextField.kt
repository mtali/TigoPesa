package com.mtali.tigopesa.core.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }

}
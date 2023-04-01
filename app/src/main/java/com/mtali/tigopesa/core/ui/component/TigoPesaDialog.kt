package com.mtali.tigopesa.core.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun TigoPesaDialog(
    modifier: Modifier = Modifier,
    @StringRes title: Int? = null,
    onCancel: () -> Unit,
    dismissible: Boolean = false,
    bgColor: Color? = null,
    body: @Composable ColumnScope.() -> Unit,
) {
    Dialog(
        onDismissRequest = {
            if (dismissible) {
                onCancel()
            }
        }) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(8.dp)
        ) {
            val mod = if (bgColor != null) modifier.background(bgColor) else modifier
            Column(
                modifier = mod
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                title?.let {
                    Text(text = stringResource(id = title), fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(6.dp))
                }
                body()
            }
        }
    }
}
package com.mtali.tigopesa.core.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.core.ui.theme.Green

@Composable
fun GreenButton(title: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Green),
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)

    ) {
        Text(
            text = stringResource(id = title).uppercase(),
            color = Color.White
        )
    }
}




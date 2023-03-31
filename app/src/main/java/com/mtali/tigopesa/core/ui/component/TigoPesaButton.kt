package com.mtali.tigopesa.core.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.core.ui.theme.Blue

@Composable
fun TigoPesaButton(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    bgColor: Color = Blue,
    icon: ImageVector? = null,
    textColor: Color = Color.White,
    uppercase: Boolean = false,
    onClick: () -> Unit = {}

) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = bgColor)
    ) {
        icon?.let {
            Image(imageVector = icon, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
        }
        val modTitle =
            if (uppercase) stringResource(id = title).uppercase() else stringResource(id = title)
        Text(text = modTitle, color = textColor)
    }
}

fun LazyListScope.tigoPesaButton(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    bgColor: Color = Blue,
    icon: ImageVector? = null,
    uppercase: Boolean = false,
    onClick: () -> Unit = {}
) {
    item {
        TigoPesaButton(
            modifier = modifier,
            title = title,
            bgColor = bgColor,
            icon = icon,
            uppercase = uppercase,
            onClick = onClick
        )
    }
}
package com.mtali.tigopesa.core.ui.component

import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.mtali.tigopesa.core.ui.theme.Blue


@Composable
fun TigoTopAppBar(
    @StringRes title: Int,
    hasBack: Boolean = true,
    onBackClick: () -> Unit = {}

) {
    TopAppBar(
        title = {
            Text(text = stringResource(title), color = Color.White)
        },
        backgroundColor = Blue,
        navigationIcon = {
            if (hasBack) {
                IconButton(onBackClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

        }
    )
}
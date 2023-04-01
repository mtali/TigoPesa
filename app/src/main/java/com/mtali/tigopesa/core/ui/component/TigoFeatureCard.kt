package com.mtali.tigopesa.core.ui.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtali.tigopesa.core.ui.theme.Blue

val featureHeight = 80.dp
val featureVerticalSpacing = 16.dp


@Composable
fun TigoFeatureCard(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    iconSize: Dp = 40.dp,
    @StringRes title: Int?,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(featureHeight)
            .clickable { onClick() },
        elevation = 4.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(iconSize)
            )
            title?.let { Text(text = stringResource(id = title), fontSize = 15.sp, color = Blue) }
        }
    }
}


fun LazyGridScope.tigoFeatureCard(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    iconSize: Dp = 40.dp,
    @StringRes title: Int?,
    onClick: () -> Unit = {}
) {
    item {
        TigoFeatureCard(
            modifier = modifier,
            icon = icon,
            title = title,
            iconSize = iconSize,
            onClick = onClick
        )
    }
}
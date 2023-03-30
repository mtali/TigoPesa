package com.mtali.tigopesa.core.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mtali.tigopesa.core.ui.theme.LogoYellow

@Composable
fun RowScope.TigoPesaNavigationBarItem(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {
    val color = if (selected) LogoYellow else Color.White
    BottomNavigationItem(
        modifier = modifier,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = color,
                modifier = Modifier.size(24.dp)
            )
        },
        selected = selected,
        selectedContentColor = Color.Cyan,
        unselectedContentColor = Color.Gray,
        onClick = onClick,
        label = {
            Text(
                text = stringResource(id = label).uppercase(),
                fontSize = 12.sp,
                color = color
            )
        },
        enabled = true,
    )
}
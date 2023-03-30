package com.mtali.tigopesa.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.mtali.tigopesa.R

enum class TopLevelDestination(
    val icon: ImageVector,
    val title: Int,
) {
    HOME(
        icon = Icons.Outlined.Home,
        title = R.string.home,
    ),
    SELF_CARE(
        icon = Icons.Outlined.AddBox,
        title = R.string.self_care,
    ),

}
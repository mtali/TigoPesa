package com.mtali.tigopesa.core.utils

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}

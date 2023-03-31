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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.core.ui.theme.Blue
import com.mtali.tigopesa.core.utils.Icon

enum class IconDirection {
    START, END
}

@Composable
fun TigoPesaButton(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    bgColor: Color = Blue,
    icon: Icon? = null,
    textColor: Color = Color.White,
    uppercase: Boolean = false,
    onClick: () -> Unit = {},
    iconDirection: IconDirection = IconDirection.START

) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = bgColor)
    ) {

        val modTitle =
            if (uppercase) stringResource(id = title).uppercase() else stringResource(id = title)

        when (iconDirection) {
            IconDirection.START -> {
                icon?.let {
                    when (icon) {
                        is Icon.DrawableResourceIcon -> {
                            Image(
                                painter = painterResource(id = icon.id),
                                contentDescription = null
                            )
                        }

                        is Icon.ImageVectorIcon -> {
                            Image(imageVector = icon.imageVector, contentDescription = null)
                        }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(text = modTitle, color = textColor)
            }

            IconDirection.END -> {
                Text(text = modTitle, color = textColor)
                icon?.let {
                    Spacer(modifier = Modifier.width(8.dp))
                    when (icon) {
                        is Icon.DrawableResourceIcon -> {
                            Image(
                                painter = painterResource(id = icon.id),
                                contentDescription = null
                            )
                        }

                        is Icon.ImageVectorIcon -> {
                            Image(imageVector = icon.imageVector, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}

fun LazyListScope.tigoPesaButton(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    bgColor: Color = Blue,
    icon: Icon? = null,
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
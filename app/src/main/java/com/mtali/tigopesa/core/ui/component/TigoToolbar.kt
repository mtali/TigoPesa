package com.mtali.tigopesa.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.theme.Blue
import com.mtali.tigopesa.core.ui.theme.LogoYellow


@Composable
fun TigoToolbar() {
    TopAppBar(backgroundColor = Blue) {
        val painter = painterResource(id = R.drawable.logo)
        Image(painter = painter, contentDescription = null)

        Spacer(modifier = Modifier.weight(1f))

        ToolbarIcon(res = R.drawable.ic_star, onClick = {})

        Spacer(modifier = Modifier.width(10.dp))

        ToolbarIcon(res = R.drawable.ic_notification, onClick = {})
    }
}

@Composable
private fun ToolbarIcon(modifier: Modifier = Modifier, res: Int, onClick: () -> Unit) {
    Icon(
        painter = painterResource(id = res),
        contentDescription = null,
        tint = LogoYellow,
        modifier = modifier
            .size(25.dp)
            .clickable {
                onClick()
            }
    )

}


@Composable
@Preview
private fun TigoToolbarPreview() {
    TigoToolbar()
}
package com.mtali.tigopesa.feature.oboarding_choose_language

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mtali.tigopesa.R
import com.mtali.tigopesa.core.ui.component.height
import com.mtali.tigopesa.core.ui.component.title
import com.mtali.tigopesa.ui.theme.BrightestGray


@Composable
fun OnboardChooseLanguageRoute() {
    OnboardChooseLanguageScreen()
}

@Composable
private fun OnboardChooseLanguageScreen() {
    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .background(BrightestGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            height(64.dp)

            logo()

            height(16.dp)

            title(title = R.string.change_language)

            height(16.dp)

            languageCard(drawable = R.drawable.flag_tz, title = R.string.swahili)

            height(8.dp)

            languageCard(drawable = R.drawable.flag_uk, title = R.string.english)
        }
    }
}


private fun LazyListScope.logo() {
    item {
        val painter = painterResource(id = R.drawable.logo)
        Image(
            painter = painter,
            contentDescription = "logo",
            modifier = Modifier
                .height(60.dp)
                .width(200.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}


private fun LazyListScope.languageCard(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes title: Int
) {
    item {
        Card(
            modifier = modifier.width(250.dp),
            shape = RoundedCornerShape(4.dp),
            elevation = 3.dp,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                val painter = painterResource(id = drawable)
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = stringResource(id = title))
            }
        }
    }

}
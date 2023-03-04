package com.mtali.tigopesa.core.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp

fun LazyListScope.height(height: Dp) {
    item { Spacer(modifier = Modifier.height(height)) }
}

fun LazyListScope.title(modifier: Modifier = Modifier, title: Int) {
    item { Text(modifier = modifier, text = stringResource(id = title)) }
}
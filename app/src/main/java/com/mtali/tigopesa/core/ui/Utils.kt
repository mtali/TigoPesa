package com.mtali.tigopesa.core.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun LazyListScope.height(size: Dp) {
    item { Spacer(modifier = Modifier.height(size)) }
}


fun Modifier.horizontal() = this
    .fillMaxWidth()
    .padding(horizontal = 16.dp)

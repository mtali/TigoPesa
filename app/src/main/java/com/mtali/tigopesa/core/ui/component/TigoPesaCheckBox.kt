package com.mtali.tigopesa.core.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun TigoPesaCheckBox(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onCheckedChange(!checked) }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

fun LazyListScope.tigoPesaCheckBox(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    item {
        TigoPesaCheckBox(
            modifier = modifier,
            text = text,
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}
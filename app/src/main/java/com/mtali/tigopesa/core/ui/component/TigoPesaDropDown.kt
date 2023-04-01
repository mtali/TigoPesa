package com.mtali.tigopesa.core.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import com.mtali.tigopesa.core.ui.theme.LightBlue


@Composable
fun TigoPesaDropdown(
    title: Int,
    placeholder: Int,
    items: List<String>,
    onSelectedIndexChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(-1) }
    val interactionSource = remember { MutableInteractionSource() }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {

        TigoTextField(
            title = title,
            placeholder = placeholder,
            value = items.getOrNull(selectedIndex) ?: "",
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates -> textFieldSize = coordinates.size.toSize() }
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    expanded = !expanded
                },
            trailingIcon = {
                val icon = if (expanded) {
                    Icons.Filled.KeyboardArrowUp
                } else {
                    Icons.Filled.KeyboardArrowDown
                }
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = LightBlue
                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .animateContentSize()
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    onSelectedIndexChange(index)
                    expanded = false
                }) {
                    Text(text = s)
                }
            }
        }
    }
}

fun LazyListScope.tigoPesaDropdown(
    modifier: Modifier = Modifier,
    title: Int,
    placeholder: Int,
    items: List<String>,
    onSelectedIndexChange: (index: Int) -> Unit
) {
    item {
        TigoPesaDropdown(
            title = title,
            placeholder = placeholder,
            items = items,
            onSelectedIndexChange = onSelectedIndexChange,
            modifier = modifier
        )
    }

}
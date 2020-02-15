package com.example.openlibrary.widget

import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import com.example.openlibrary.extension.join

@Composable
fun ListView(
    header: (@Composable() () -> Unit)? = null,
    divider: (@Composable() () -> Unit)? = null,
    bodyColor: Color = MaterialTheme.colors().surface,
    bodyModifier: Modifier = Modifier.None,
    bodyItems: List<@Composable() () -> Unit>
) {
    Column(modifier = LayoutHeight.Fill) {
        header?.invoke()

        val items = if (divider != null) bodyItems.join(divider) else bodyItems
        Surface(color = bodyColor) {
            Column(modifier = bodyModifier) {
                items.forEach { it() }
            }
        }
    }
}

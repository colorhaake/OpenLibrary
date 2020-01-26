package com.example.openlibrary.widget

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import com.example.openlibrary.extension.join

@Composable
fun ListView(
    header: (@Composable() () -> Unit)? = null,
    divider: (@Composable() () -> Unit)? = null,
    bodyColor: Color = (+MaterialTheme.colors()).surface,
    bodyModifier: Modifier = Modifier.None,
    bodyItems: List<@Composable() () -> Unit>
) {
    Column(modifier = Expanded) {
        header?.invoke()

        val items = if (divider != null) bodyItems.join(divider) else bodyItems
        Surface(color = bodyColor) {
            Column(modifier = bodyModifier) {
                items.forEach { it() }
            }
        }
    }
}

@Composable
fun ListItem(
    padding: EdgeInsets = EdgeInsets(left = 16.dp, top = 12.dp, right = 16.dp, bottom = 12.dp),
    height: Dp = 48.dp,
    left: (@Composable() () -> Unit)? = null,
    middle: (@Composable() () -> Unit)? = null,
    right: (@Composable() () -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    // TODO add click selector for active state
    Ripple(bounded = true) {
        Clickable(onClick = onClick) {
            Container(
                padding = padding,
                height = height
            ) {
                Stack(modifier = ExpandedWidth) {
                    left?.apply {
                        aligned(alignment = Alignment.CenterLeft) {
                            this()
                        }
                    }

                    middle?.apply {
                        positioned(leftInset = 72.dp, rightInset = 72.dp) {
                            this()
                        }
                    }

                    right?.apply {
                        aligned(alignment = Alignment.CenterRight) {
                            this()
                        }
                    }
                }
            }
        }
    }
}

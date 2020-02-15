package com.example.openlibrary.widget

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.ContentPadding
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.unit.dp

// TODO find a better name
@Suppress("LocalVariableName")
@Composable
fun LeftMiddleRight(
    modifier: Modifier = Modifier.None,
    padding: ContentPadding = ContentPadding(0.dp),
    color: Color = MaterialTheme.colors().surface,
    left: (@Composable() () -> Unit)? = null,
    middle: (@Composable() () -> Unit)? = null,
    right: (@Composable() () -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    Ripple(bounded = true, enabled = onClick != null) {
        Clickable(onClick = onClick) {
            Card(modifier = modifier, color = color) {
                Container(padding = padding) {
                    Stack(modifier = LayoutWidth.Fill) {
                        middle?.apply {
                            Container(modifier = LayoutHeight.Fill) {
                                this()
                            }
                        }

                        left?.apply {
                            Container(modifier = LayoutGravity.CenterLeft + LayoutHeight.Fill) {
                                this()
                            }
                        }

                        right?.apply {
                            Container(modifier = LayoutGravity.CenterRight + LayoutHeight.Fill) {
                                this()
                            }
                        }
                    }
                }
            }
        }
    }
}

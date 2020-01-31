package com.example.openlibrary.explore

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.material.Button
import androidx.ui.tooling.preview.Preview

@Composable
fun ExploreContent(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Open Drawer")
    }
}

@Preview
@Composable
fun preview() {
    ExploreContent {}
}

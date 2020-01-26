package com.example.openlibrary.explore

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Container
import androidx.ui.material.Button
import androidx.ui.tooling.preview.Preview
import com.example.openlibrary.explore.drawer.ExploreDrawer

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

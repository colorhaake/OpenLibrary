package com.example.openlibrary.explore.content

import androidx.compose.Composable
import androidx.ui.foundation.ContentPadding
import androidx.ui.layout.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Composable
fun ExploreContent(onMenuClick: () -> Unit) {
    Column {
        // TODO add Radius
        SearchBar(
            modifier = LayoutWidth.Fill + LayoutHeight(48.dp),
            margin = ContentPadding(all = 8.dp),
            onMenuClick = onMenuClick,
            onMicClick = {}
        )
    }
}

@Preview
@Composable
fun preview() {
    ExploreContent {}
}

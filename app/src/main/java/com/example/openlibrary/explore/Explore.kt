package com.example.openlibrary.explore

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.material.DrawerState
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ModalDrawerLayout
import com.example.openlibrary.explore.drawer.ExploreDrawer

@Composable
fun Explore() {
    val (drawerState, onDrawerStateChange) = +state { DrawerState.Closed }
    
    MaterialTheme {
        ModalDrawerLayout(
            drawerState = drawerState,
            onStateChange = onDrawerStateChange,
            drawerContent = { ExploreDrawer() },
            bodyContent = { ExploreContent { onDrawerStateChange(DrawerState.Opened) } }
        )
    }
}
package com.example.openlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.ColoredRect
import androidx.ui.graphics.Color
import androidx.ui.layout.Container
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.example.openlibrary.explore.Explore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Container {
                    Explore()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Explore()
    }
}

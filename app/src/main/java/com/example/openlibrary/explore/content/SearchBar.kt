package com.example.openlibrary.explore.content

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.ContentPadding
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.LayoutWidth
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.openlibrary.R
import com.example.openlibrary.style.ROBOTO_FONT_FAMILY
import com.example.openlibrary.widget.ExTextField
import com.example.openlibrary.widget.LeftMiddleRight
import com.example.openlibrary.widget.VectorImageButton

@Composable
fun SearchBar(
    modifier: Modifier = Modifier.None,
    margin: ContentPadding = ContentPadding(0.dp),
    onMenuClick: () -> Unit,
    onMicClick: () -> Unit
) {
    Container(modifier =
        LayoutPadding(
            left = margin.left,
            top = margin.top,
            right = margin.right,
            bottom = margin.bottom
        )
    ) {
        LeftMiddleRight(
            modifier = modifier,
            padding = ContentPadding(left = 16.dp, top = 12.dp, right = 16.dp, bottom = 12.dp),
            color = Color.White,
            left = {
                VectorImageButton(
                    modifier = LayoutSize(24.dp),
                    id = R.drawable.ic_menu,
                    onClick = onMenuClick
                )
            },
            middle = {
                Container(
                    modifier = LayoutWidth.Fill + LayoutPadding(
                        left = 72.dp,
                        right = 55.dp
                    )
                ) {
                    ExTextField(
                        value = "",
                        hintValue = "Search books, genres & authors",
                        hintTextStyle = TextStyle(
                            color = Color(0x61000000),
                            fontSize = 16.sp,
                            fontFamily = ROBOTO_FONT_FAMILY
                        ),
                        onValueChange = {},
                        imeAction = ImeAction.Search,
                        onImeActionPerformed = {}
                    )
                }
            },
            right = {
                VectorImageButton(
                    modifier = LayoutSize(24.dp),
                    id = R.drawable.ic_mic,
                    onClick = onMicClick
                )
            }
        )
    }
}

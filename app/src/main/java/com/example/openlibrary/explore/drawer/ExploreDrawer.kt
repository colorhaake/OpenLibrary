package com.example.openlibrary.explore.drawer

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.ColoredRect
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.Switch
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import com.example.openlibrary.R
import com.example.openlibrary.style.COLOR_PRIMARY
import com.example.openlibrary.style.ROBOTO_FONT_FAMILY
import com.example.openlibrary.widget.ListItem
import com.example.openlibrary.widget.ListView
import com.example.openlibrary.widget.VectorImage

@Composable
fun ExploreDrawer() {
    ListView(
        header = { Profile() },
        divider = { Divider(color = Color(0x1E000000)) },
        bodyColor = Color(0xFFFAFAFA),
        bodyModifier = Expanded,
        bodyItems = listOf(
            { Navigation() },
            { Settings() }
        )
    )
}

@Composable
private fun Profile() {
    val bgImage = +imageResource(R.drawable.illustration)
    Container(modifier = ExpandedWidth, height = 148.dp) {
        Stack {
            expanded {
                ColoredRect(color = COLOR_PRIMARY)
            }

            aligned(alignment = Alignment.TopRight) {
                Container(
                    modifier = Spacing(top = 4.dp),
                    width = 191.dp,
                    height = 144.dp
                ) {
                    DrawImage(image = bgImage)
                }
            }

            aligned(alignment = Alignment.TopLeft) {
                Column {
                    Avatar()
                    UserInfo()
                }
            }
        }
    }
}

@Composable
private fun Avatar() {
    val userImage = +imageResource(R.drawable.userpic)

    Container(
        modifier = Spacing(left = 16.dp, top = 16.dp),
        width = 64.dp,
        height = 64.dp
    ) {
        Clip(shape = CircleShape) {
            DrawImage(image = userImage)
        }
    }
}

@Composable
private fun UserInfo() {
    Container(
        modifier = Spacing(top = 4.dp, bottom = 8.dp),
        padding = EdgeInsets(left = 16.dp, top = 7.dp, right = 16.dp, bottom = 7.dp)
    ) {
        Column {
            // TODO fontFamily, line height, lineSpacingExtra
            Text(
                text = "Lulu Pearson",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = ROBOTO_FONT_FAMILY
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                text = "lulupe@gmail.com",
                style = TextStyle(
                    color = Color(0xDFFFFFFF),
                    fontSize = 14.sp,
                    fontFamily = ROBOTO_FONT_FAMILY
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun Navigation() {
    Column(modifier = Spacing(top = 8.dp)) {
        NavigationItem(
            activeIcon = R.drawable.ic_explore_active,
            inactiveIcon = R.drawable.ic_explore_inactive,
            title = "Explore",
            onClick = {}
        )
        NavigationItem(
            activeIcon = R.drawable.ic_book_active,
            inactiveIcon = R.drawable.ic_book_inactive,
            title = "My books",
            onClick = {}
        )
        NavigationItem(
            activeIcon = R.drawable.ic_star_active,
            inactiveIcon = R.drawable.ic_star_inactive,
            title = "Manage suggestions",
            onClick = {}
        )
    }
}

@Composable
private fun NavigationItem(
    @DrawableRes activeIcon: Int,
    @DrawableRes inactiveIcon: Int,
    title: String,
    onClick: () -> Unit
) {
    // TODO add click selector for active state
    ListItem(
        left = {
            VectorImage(id = inactiveIcon)
        },
        middle = {
            Text(
                text = title,
                style = TextStyle(
                    color = Color(0xDE000000),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = ROBOTO_FONT_FAMILY
                )
            )
        },
        onClick = onClick
    )
}

@Composable
private fun Settings() {
    Column {
        SettingsLabel()
        NotificationItem()
        NavigationItem(
            activeIcon = R.drawable.ic_help_active,
            inactiveIcon = R.drawable.ic_help_inactive,
            title = "Help & Feedback",
            onClick = {}
        )
    }
}

@Composable
private fun SettingsLabel() {
    ListItem(left = {
        Text(
            text = "Settings",
            style = TextStyle(
                color = Color(0x8A000000),
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                fontFamily = ROBOTO_FONT_FAMILY
            )
        )
    })
}

@Composable
private fun NotificationItem() {
    val checkedState = +state { true }

    ListItem(
        left = {
            VectorImage(id = R.drawable.ic_bell_inactive)
        },
        middle = {
            Text(
                text = "Notifications",
                style = TextStyle(
                    color = Color(0xDE000000),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = ROBOTO_FONT_FAMILY
                )
            )
        },
        right = {
            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                color = Color(0xFFFF5722)
            )
        }
    )

}

@Preview
@Composable
fun preview() {
    ExploreDrawer()
}
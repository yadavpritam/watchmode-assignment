package com.example.watchmodeapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.watchmodeapp.data.model.dto.TitleDto

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Watchmode",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            tint = Color.White
        )
    }
}
@Composable
fun HomeTabs(
    tabs: List<String>,
    selectedTab: Int,
    onTabChange: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(Color(0xFF2C2C2E), RoundedCornerShape(14.dp))
            .padding(4.dp)
    ) {
        tabs.forEachIndexed { index, title ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedTab == index) Color(0xFFE60A15)
                        else Color.Transparent
                    )
                    .clickable { onTabChange(index) }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    color = if (selectedTab == index) Color.White else Color.LightGray,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
@Composable
fun MovieTextList(
    list: List<TitleDto>,
    onItemClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            Text(
                text = "Trending Now",
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        items(list) { item ->
            MovieTextItem(item = item, onItemClick = onItemClick)
        }
    }
}
@Composable
fun MovieTextItem(
    item: TitleDto,
    onItemClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2C2C2E), RoundedCornerShape(16.dp))
            .clickable { onItemClick(item.id) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // TEXT AREA
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = item.title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "${item.year ?: "—"}  •  ${item.type.uppercase()}",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Details",
            tint = Color.LightGray,
            modifier = Modifier.size(22.dp)
        )
    }
}
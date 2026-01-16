package com.example.watchmodeapp.ui.home

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerList() {
    LazyColumn {

        item { TabsShimmer() }
        item { SectionHeaderShimmer() }

        items(8) {
            MovieItemShimmer()
            Divider(color = Color.White.copy(0.05f))
        }
    }
}

@Composable
fun shimmerBrush(): Brush {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val x by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing)
        ),
        label = "shimmerAnim"
    )

    return Brush.linearGradient(
        colors = listOf(
            Color(0xFF2A2A32),
            Color(0xFF3A3A45),
            Color(0xFF2A2A32)
        ),
        start = Offset(x - 300f, 0f),
        end = Offset(x, 0f)
    )
}

@Composable
fun ShimmerBox(
    modifier: Modifier,
    radius: Int = 8,
) {
    Box(
        modifier = modifier
            .background(
                brush = shimmerBrush(),
                shape = RoundedCornerShape(radius.dp)
            )
    )
}

@Composable
fun TabsShimmer() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White.copy(0.05f), RoundedCornerShape(14.dp))
            .padding(6.dp)
            .fillMaxWidth()
    ) {
        ShimmerBox(
            modifier = Modifier
                .weight(1f)
                .height(36.dp),
            radius = 10
        )
        Spacer(Modifier.width(8.dp))
        ShimmerBox(
            modifier = Modifier
                .weight(1f)
                .height(36.dp),
            radius = 10
        )
    }
}

@Composable
fun MovieItemShimmer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ShimmerBox(
                modifier = Modifier
                    .height(18.dp)
                    .fillMaxWidth(0.7f)
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ShimmerBox(Modifier
                    .height(12.dp)
                    .width(40.dp))
                ShimmerBox(Modifier
                    .height(12.dp)
                    .width(70.dp))
            }
        }

        // Info icon placeholder
        ShimmerBox(
            modifier = Modifier.size(22.dp),
            radius = 6
        )
    }
}

@Composable
fun SectionHeaderShimmer() {
    ShimmerBox(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .height(18.dp)
            .width(140.dp)
    )
}

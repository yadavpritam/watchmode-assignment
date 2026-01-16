package com.example.watchmodeapp.ui.detail

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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailsShimmer() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0E0E11))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            // ===== HERO BACKDROP =====
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3f / 4f)
            ) {
                DetailsShimmerBox(
                    modifier = Modifier.fillMaxSize(),
                    darker = true
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color(0xFF0E0E11)
                                )
                            )
                        )
                )
            }

            // ===== CONTENT AREA (overlap) =====
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .offset(y = (-120).dp)
            ) {

                Spacer(Modifier.height(12.dp))

                // Title
                DetailsShimmerBox(
                    modifier = Modifier
                        .height(36.dp)
                        .fillMaxWidth(0.75f)
                )

                Spacer(Modifier.height(16.dp))

                // Metadata row
                Row(verticalAlignment = Alignment.CenterVertically) {
                    DetailsShimmerBox(
                        modifier = Modifier
                            .height(18.dp)
                            .width(48.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Box(
                        Modifier
                            .size(4.dp)
                            .background(Color.Gray, CircleShape)
                    )
                    Spacer(Modifier.width(8.dp))
                    DetailsShimmerBox(
                        modifier = Modifier
                            .height(18.dp)
                            .width(64.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Box(
                        Modifier
                            .size(4.dp)
                            .background(Color.Gray, CircleShape)
                    )
                    Spacer(Modifier.width(8.dp))
                    DetailsShimmerBox(
                        modifier = Modifier
                            .height(18.dp)
                            .width(96.dp)
                    )
                }

                Spacer(Modifier.height(28.dp))

                // ===== ACTION BUTTONS =====
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

                    DetailsShimmerBox(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp)
                    )

                    DetailsShimmerBox(
                        modifier = Modifier
                            .size(56.dp)
                    )
                }

                Spacer(Modifier.height(32.dp))

                // ===== SYNOPSIS =====
                DetailsShimmerBox(
                    modifier = Modifier
                        .height(22.dp)
                        .width(120.dp),
                    darker = true
                )

                Spacer(Modifier.height(16.dp))

                repeat(4) {
                    DetailsShimmerBox(
                        modifier = Modifier
                            .height(16.dp)
                            .fillMaxWidth()
                    )
                    Spacer(Modifier.height(10.dp))
                }

                DetailsShimmerBox(
                    modifier = Modifier
                        .height(16.dp)
                        .fillMaxWidth(0.7f)
                )

                Spacer(Modifier.height(36.dp))

                // ===== CAST =====
                DetailsShimmerBox(
                    modifier = Modifier
                        .height(22.dp)
                        .width(80.dp),
                    darker = true
                )

                Spacer(Modifier.height(16.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(5) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            DetailsShimmerBox(
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(Modifier.height(8.dp))
                            DetailsShimmerBox(
                                modifier = Modifier
                                    .height(12.dp)
                                    .width(48.dp)
                            )
                        }
                    }
                }

                Spacer(Modifier.height(36.dp))

                // ===== WHERE TO WATCH =====
                DetailsShimmerBox(
                    modifier = Modifier
                        .height(22.dp)
                        .width(160.dp),
                    darker = true
                )

                Spacer(Modifier.height(16.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    repeat(4) {
                        DetailsShimmerBox(
                            modifier = Modifier
                                .size(48.dp)
                        )
                    }
                }

                Spacer(Modifier.height(120.dp))
            }
        }

        // ===== TOP NAV BUTTONS =====
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopStart),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DetailsShimmerBox(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                DetailsShimmerBox(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                DetailsShimmerBox(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun detailsShimmerBrush(): Brush {
    val transition = rememberInfiniteTransition(label = "detailsShimmer")
    val translate by transition.animateFloat(
        initialValue = -800f,
        targetValue = 800f,
        animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = LinearEasing)
        ),
        label = "detailsShimmerAnim"
    )

    return Brush.linearGradient(
        colors = listOf(
            Color(0xFF1E2024),
            Color(0xFF2A2C32),
            Color(0xFF1E2024)
        ),
        start = Offset(translate, 0f),
        end = Offset(translate + 400f, 0f)
    )
}

@Composable
fun DetailsShimmerBox(
    modifier: Modifier = Modifier,
    darker: Boolean = false,
) {
    val brush = detailsShimmerBrush()

    Box(
        modifier = modifier
            .background(
                brush = brush,
                shape = RoundedCornerShape(12.dp)
            )
            .alpha(if (darker) 0.7f else 1f)
    )
}
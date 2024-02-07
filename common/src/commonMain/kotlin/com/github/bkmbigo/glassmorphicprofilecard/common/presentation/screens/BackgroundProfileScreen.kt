package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.bkmbigo.glassmorphicprofilecard.common.models.User
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.components.ProfileCard
import kotlin.random.Random

/* This screen is concerned with drawing a background */
@Composable
fun BackgroundProfileScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawMyBackground(),
            contentAlignment = Alignment.Center
        ) {
            ProfileCard(
                currentUser = User.localUsers[0],
                modifier = Modifier
                    .width(300.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                )
            )
        }
    }

}

@Stable
/** Draws my specified background behind the composable */
internal fun Modifier.drawMyBackground(): Modifier =
    drawBehind {

        drawCircle(
            color = Color.Magenta,
            radius = 75f, /* Decide whether to make size adaptive to screen size */
            alpha = 0.2f,
            center = Offset(
                x = size.width * 0.65f,
                y = size.height * 0.65f
            )
        )

        drawCircle(
            color = Color.Magenta,
            radius = 75f,
            alpha = 0.2f,
            center = Offset(
                x = size.width * 0.8f,
                y = size.height * 0.45f
            )
        )

        drawCircle(
            color = Color.Magenta,
            radius = 75f,
            alpha = 0.2f,
            center = Offset(
                x = size.width * 0.33f,
                y = size.height * 0.35f
            )
        )

    }

private fun generateRandomCenters(count: Int, width: Float, height: Float): List<Offset> =
    mutableListOf<Offset>().apply {
        repeat(count) {
            add(
                Offset(
                    x = Random.nextFloat() * width,
                    y = Random.nextFloat() * height
                )
            )
        }
    }

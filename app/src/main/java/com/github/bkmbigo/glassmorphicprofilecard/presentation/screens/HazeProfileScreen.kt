package com.github.bkmbigo.glassmorphicprofilecard.presentation.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.bkmbigo.glassmorphicprofilecard.R
import com.github.bkmbigo.glassmorphicprofilecard.domain.User
import com.github.bkmbigo.glassmorphicprofilecard.presentation.components.ProfileCard
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild

@Preview
@Composable
fun HazeBackgroundScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Transparent
    ) {

        val hazeState = remember { HazeState() }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .haze(
                        hazeState,
                        backgroundColor = Color.White.copy(alpha = 0.35f),
                        tint = Color.Black.copy(alpha = 0.15f),
                        blurRadius = 25.dp,
                        noiseFactor = 0.15f
                    )
            ) {
                if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Image(
                        painter = painterResource(id = R.drawable.room_potrait),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.room_landscape),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Box(
                modifier = Modifier
                    .width(350.dp)
                    .hazeChild(hazeState, shape = RoundedCornerShape(12.dp))
            ) {
                ProfileCard(
                    currentUser = User.localUsers[0],
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                )
            }


        }

    }
}
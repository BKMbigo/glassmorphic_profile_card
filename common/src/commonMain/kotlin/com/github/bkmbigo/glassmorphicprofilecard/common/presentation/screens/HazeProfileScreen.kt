package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.github.bkmbigo.glassmorphicprofilecard.common.models.User
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.components.ProfileCard
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze.HazeState
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze.HazeStyle
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze.haze
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze.hazeChild
import glassmorphicprofilecard.common.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

//@Preview
@OptIn(ExperimentalResourceApi::class)
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
                        hazeState = hazeState,
                        /* [backgroundColor] is completely ignored in Compose-multiplatform */
                        backgroundColor = Color.Black.copy(alpha = 0.8f),
                        hazeStyle = HazeStyle(
                            tint = Color.White.copy(alpha = 0.10f),
                            blurRadius = 20.dp,
                            noiseFactor = 0.10f
                        )
                    )
            ) {
//                if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Image(
                        painter = painterResource(resource = Res.drawable.room_potrait),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
//                } else {
//                    Image(
//                        painter = painterResource(resource = Res.drawable.room_landscape),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .fillMaxSize(),
//                        contentScale = ContentScale.Crop
//                    )
//                }
            }

            Box(
                modifier = Modifier
                    .width(350.dp)
                    .padding(vertical = 24.dp)
                    .hazeChild(
                        hazeState,
                        shape = RoundedCornerShape(12.dp),
                        /* [hazeState] is completely ignored on android */
                    )
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

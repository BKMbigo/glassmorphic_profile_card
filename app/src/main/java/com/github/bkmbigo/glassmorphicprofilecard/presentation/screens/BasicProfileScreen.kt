package com.github.bkmbigo.glassmorphicprofilecard.presentation.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.bkmbigo.glassmorphicprofilecard.domain.User
import com.github.bkmbigo.glassmorphicprofilecard.presentation.theme.andikaFontFamily
import com.github.bkmbigo.glassmorphicprofilecard.presentation.theme.ubuntuFontFamily

@Preview
@Composable
fun BasicProfileScreen() {

    val currentUser = remember { User.localUsers[0] }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            ElevatedCard(
                modifier = Modifier
                    .width(350.dp),
                shape = RoundedCornerShape(12.dp)
            ) {

                var isShowingFullBio by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = currentUser.profilePhoto),
                        contentDescription = null,
                        modifier = Modifier
                            .size(54.dp)
                            .clip(RoundedCornerShape(100))
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = currentUser.name,
                        fontFamily = ubuntuFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AnimatedContent(
                        targetState = isShowingFullBio,
                        label = "bio",
                        transitionSpec = {
                            if (!isShowingFullBio) {
                                expandVertically(expandFrom = Alignment.Top) togetherWith fadeOut(
                                    animationSpec = tween(1)
                                )
                            } else {
                                fadeIn(animationSpec = tween(1)) togetherWith shrinkVertically(
                                    shrinkTowards = Alignment.Top
                                )
                            }
                        },
                        contentAlignment = Alignment.BottomCenter
                    ) { isShowingFullBio ->
                        if (!isShowingFullBio) {
                            Text(
                                text = currentUser.bio,
                                modifier = Modifier
                                    .padding(horizontal = 4.dp),
                                fontFamily = andikaFontFamily,
                                fontSize = 12.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 2
                            )
                        } else {
                            Text(
                                text = currentUser.bio,
                                modifier = Modifier
                                    .padding(horizontal = 4.dp),
                                fontFamily = andikaFontFamily,
                                fontSize = 12.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp)
                            .border(
                                width = 1.dp,
                                color = LocalContentColor.current,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 4.dp, vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                            )

                            Text(
                                text = currentUser.emailAddress,
                                modifier = Modifier
                                    .weight(1f, true)
                                    .padding(horizontal = 8.dp),
                                fontFamily = andikaFontFamily
                            )


                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            isShowingFullBio = !isShowingFullBio
                        },
                        shape = RoundedCornerShape(20)
                    ) {
                        Text(
                            text = if (!isShowingFullBio) {
                                "Show full bio"
                            } else {
                                "Hide bio"
                            },
                            fontFamily = andikaFontFamily
                        )
                    }
                }
            }

        }
    }

}
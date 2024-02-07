package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.bkmbigo.glassmorphicprofilecard.common.models.User
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.theme.GlassmorphicProfileCardTheme
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.theme.MyLocalTypography
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/** A card that displays user's information */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProfileCard(
    currentUser: User,
    modifier: Modifier = Modifier,
    colors: CardColors = CardDefaults.elevatedCardColors()
) {

    val myLocalType = MyLocalTypography.current

    Card(
        modifier = modifier,
        colors = colors,
        shape = RoundedCornerShape(12.dp)
    ) {

        var isShowingFullBio by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(resource = currentUser.profilePhoto),
                contentDescription = null,
                modifier = Modifier
                    .size(54.dp)
                    .clip(RoundedCornerShape(100))
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = currentUser.name,
                fontFamily = myLocalType.UbuntuFont,
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            AnimatedContent(
                targetState = isShowingFullBio,
                label = "bio",
                transitionSpec = {
                    expandVertically(
                        animationSpec = tween(1500),
                        expandFrom = Alignment.Top
                    ) togetherWith shrinkVertically(
                        animationSpec = tween(1500),
                        shrinkTowards = Alignment.Top
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) { isShowingFullBio ->
                if (!isShowingFullBio) {
                    Text(
                        text = currentUser.bio,
                        modifier = Modifier
                            .padding(horizontal = 4.dp),
                        fontFamily = myLocalType.AndikaFont,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        color = Color.White
                    )
                } else {
                    Text(
                        text = currentUser.bio,
                        modifier = Modifier
                            .padding(horizontal = 4.dp),
                        fontFamily = myLocalType.AndikaFont,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White
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
                        color = Color.White,
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
                            .size(20.dp),
                        tint = Color.White
                    )

                    Text(
                        text = currentUser.emailAddress,
                        modifier = Modifier
                            .weight(1f, true)
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        fontFamily = myLocalType.AndikaFont,
                        color = Color.White
                    )


                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp),
                        tint = Color.White
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
                    fontFamily = myLocalType.AndikaFont
                )
            }
        }
    }
}

//@Preview
@Composable
private fun PreviewProfileCard() {
    GlassmorphicProfileCardTheme {
        Surface(
            color = Color.Black
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ProfileCard(
                    currentUser = User.localUsers[0],
                    modifier = Modifier
                        .width(300.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color.DarkGray
                    )
                )
            }
        }
    }

}

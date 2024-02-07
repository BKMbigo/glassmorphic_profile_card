package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.bkmbigo.glassmorphicprofilecard.common.models.User
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.components.ProfileCard

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

            ProfileCard(
                currentUser = currentUser,
                modifier = Modifier
                    .width(300.dp)
            )

        }
    }

}
package com.github.bkmbigo.glassmorphicprofilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.bkmbigo.glassmorphicprofilecard.presentation.screens.BackgroundProfileScreen
import com.github.bkmbigo.glassmorphicprofilecard.presentation.screens.BasicProfileScreen
import com.github.bkmbigo.glassmorphicprofilecard.presentation.screens.HazeBackgroundScreen
import com.github.bkmbigo.glassmorphicprofilecard.presentation.theme.GlassmorphicProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlassmorphicProfileCardTheme {
//                BasicProfileScreen()
//                BackgroundProfileScreen()
                HazeBackgroundScreen()
            }
        }
    }
}

package com.github.bkmbigo.glassmorphicprofilecard

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.screens.HazeBackgroundScreen
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.theme.GlassmorphicProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val view = LocalView.current
            if (!view.isInEditMode) {
                SideEffect {
                    val window = (view.context as Activity).window
                    window.statusBarColor = Color.Black.toArgb()
                    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
                }
            }


            GlassmorphicProfileCardTheme {
//                BasicProfileScreen()
//                BackgroundProfileScreen()
                HazeBackgroundScreen()
            }
        }
    }
}

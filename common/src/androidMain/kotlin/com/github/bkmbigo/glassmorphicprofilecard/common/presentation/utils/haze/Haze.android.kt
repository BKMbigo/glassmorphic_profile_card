package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze

import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.chrisbanes.haze.haze

@SuppressLint("ModifierFactoryUnreferencedReceiver")
actual fun Modifier.haze(
    hazeState: HazeState,
    backgroundColor: Color,
    hazeStyle: HazeStyle
) = haze(
    state = hazeState,
    backgroundColor = backgroundColor,
    tint = hazeStyle.tint,
    blurRadius = hazeStyle.blurRadius,
    noiseFactor = hazeStyle.noiseFactor
)

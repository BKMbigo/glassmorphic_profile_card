package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

expect class HazeStyle(
    tint: Color = Color.Unspecified,
    blurRadius: Dp = Dp.Unspecified,
    noiseFactor: Float = -1f,
) {
    companion object {
        val Unspecified: HazeStyle
    }
}

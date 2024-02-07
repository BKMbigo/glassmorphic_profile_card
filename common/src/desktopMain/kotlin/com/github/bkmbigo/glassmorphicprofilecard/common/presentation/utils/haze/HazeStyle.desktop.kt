package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Immutable
actual class HazeStyle actual constructor(
    val tint: Color,
    val blurRadius: Dp,
    val noiseFactor: Float
) {
    actual companion object {
        actual val Unspecified: HazeStyle = HazeStyle()
    }

    fun toChrisBanesHazeStyle(): dev.chrisbanes.haze.HazeStyle =
        dev.chrisbanes.haze.HazeStyle(tint, blurRadius, noiseFactor)
}

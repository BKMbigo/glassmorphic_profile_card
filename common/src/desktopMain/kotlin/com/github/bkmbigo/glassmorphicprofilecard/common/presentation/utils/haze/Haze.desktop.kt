package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.chrisbanes.haze.haze

actual fun Modifier.haze(
    hazeState: HazeState,
    backgroundColor: Color,
    hazeStyle: HazeStyle
): Modifier = haze(hazeState, hazeStyle.toChrisBanesHazeStyle())

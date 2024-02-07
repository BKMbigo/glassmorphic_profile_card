package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import dev.chrisbanes.haze.hazeChild as chrisBanesHazeChild

actual fun Modifier.hazeChild(
    hazeState: HazeState,
    shape: Shape,
    hazeStyle: HazeStyle
): Modifier = chrisBanesHazeChild(hazeState, shape, hazeStyle.toChrisBanesHazeStyle())

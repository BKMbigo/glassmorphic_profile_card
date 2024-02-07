package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze

import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import dev.chrisbanes.haze.hazeChild as chrisBanesHazeChild

@SuppressLint("ModifierFactoryUnreferencedReceiver")
actual fun Modifier.hazeChild(
    hazeState: HazeState,
    shape: Shape,
    hazeStyle: HazeStyle
): Modifier = chrisBanesHazeChild(
    state = hazeState,
    shape = shape
    /* Haze style is ignored */
)

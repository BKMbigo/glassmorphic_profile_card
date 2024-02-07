package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

expect fun Modifier.hazeChild(
    hazeState: HazeState,
    shape: Shape = RectangleShape,
    hazeStyle: HazeStyle = HazeStyle.Unspecified
): Modifier

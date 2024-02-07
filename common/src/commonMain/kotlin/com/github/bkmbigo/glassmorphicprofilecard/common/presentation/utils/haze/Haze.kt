package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.utils.haze

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

expect fun Modifier.haze(
    hazeState: HazeState,
    backgroundColor: Color,
    hazeStyle: HazeStyle = HazeStyle.Unspecified
): Modifier

package com.github.bkmbigo.glassmorphicprofilecard.common.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import glassmorphicprofilecard.common.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font as ComposeFont


interface MyLocalType {
    val UbuntuFont: FontFamily
    val AndikaFont: FontFamily
}

val MyLocalTypography = staticCompositionLocalOf<MyLocalType> {
    object : MyLocalType {
        override val UbuntuFont: FontFamily = FontFamily.Default
        override val AndikaFont: FontFamily = FontFamily.Default
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun getMyLocalType(): MyLocalType =
    object : MyLocalType {
        override val UbuntuFont: FontFamily = FontFamily(
            ComposeFont(
                resource = Res.font.ubuntu_regular,
            ),
            ComposeFont(
                resource = Res.font.ubuntu_bold,
                weight = FontWeight.Bold
            )
        )
        override val AndikaFont: FontFamily = FontFamily(
            ComposeFont(
                resource = Res.font.andika_regular
            ),
            ComposeFont(
                resource = Res.font.andika_bold,
                weight = FontWeight.Bold
            )
        )
    }

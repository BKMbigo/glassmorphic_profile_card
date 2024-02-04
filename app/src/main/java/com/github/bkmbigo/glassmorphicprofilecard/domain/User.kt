package com.github.bkmbigo.glassmorphicprofilecard.domain

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable

@Stable
data class User(
    @DrawableRes
    val profilePhoto: Int,
    val name: String,
    val bio: String,
    val emailAddress: String
)

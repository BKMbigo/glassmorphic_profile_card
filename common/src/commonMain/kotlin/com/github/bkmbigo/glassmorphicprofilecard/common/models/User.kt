package com.github.bkmbigo.glassmorphicprofilecard.common.models

import androidx.compose.runtime.Stable
import glassmorphicprofilecard.common.generated.resources.Res
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Stable
data class User(
    val profilePhoto: DrawableResource,
    val name: String,
    val bio: String,
    val emailAddress: String
) {


    companion object {
        val localUsers = listOf(
            User(
                profilePhoto = Res.drawable.user_brian_mbigo,
                name = "Brian Mbigo",
                bio = "Hello World! I'm Brian Mbigo, a dynamic Kotlin developer on a mission to weave innovation into the fabric of software. With a solid foundation in Computer Science, I traverse the tech landscape, leveraging Kotlin's versatility to create elegant solutions for diverse applications. From mastering Android app development to building robust server-side systems, my journey is fueled by a passion for turning complex challenges into streamlined code. I thrive on the constant evolution of technology, constantly pushing boundaries to craft efficient and scalable solutions. As an ardent advocate for creative problem-solving, I don't just code; I innovate, ensuring every line contributes to the seamless fusion of technology and user experience.",
                emailAddress = "brimbigo@gmail.com"
            )
        )

    }

}

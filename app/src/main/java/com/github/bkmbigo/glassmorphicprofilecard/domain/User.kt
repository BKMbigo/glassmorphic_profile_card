package com.github.bkmbigo.glassmorphicprofilecard.domain

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import com.github.bkmbigo.glassmorphicprofilecard.R

@Stable
data class User(
    @DrawableRes
    val profilePhoto: Int,
    val name: String,
    val bio: String,
    val emailAddress: String
) {


    companion object {

        val localUsers = listOf(
            User(
                profilePhoto = R.drawable.user_brian_mbigo,
                name = "Brian Mbigo",
                bio = """
                    Hello World! I'm Brian Mbigo, a dynamic Kotlin developer on a mission to weave innovation into the fabric of software. With a solid foundation in Computer Science, I traverse the tech landscape, leveraging Kotlin's versatility to create elegant solutions for diverse applications. From mastering Android app development to building robust server-side systems, my journey is fueled by a passion for turning complex challenges into streamlined code. I thrive on the constant evolution of technology, constantly pushing boundaries to craft efficient and scalable solutions. As an ardent advocate for creative problem-solving, I don't just code; I innovate, ensuring every line contributes to the seamless fusion of technology and user experience.
                """.trimIndent(),
                emailAddress = "brimbigo@gmail.com"
            )
        )

    }

}

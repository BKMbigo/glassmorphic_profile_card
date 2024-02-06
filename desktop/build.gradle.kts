import org.jetbrains.compose.desktop.application.dsl.TargetFormat

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose.multiplatform)
}

dependencies {
    implementation(project(":common"))

    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "Mainkt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Glassmorphic Design"
            packageVersion = "1.0.0"
        }
    }
}
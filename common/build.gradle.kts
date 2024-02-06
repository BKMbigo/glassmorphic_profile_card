@Suppress
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {

    applyDefaultHierarchyTemplate()

    androidTarget()
    jvm("desktop")
    js(IR) {
        browser()
    }
    wasmJs {
        browser()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material3)
                implementation(compose.components.resources)
            }
        }

        val webMain by creating {
            dependsOn(commonMain)
            dependencies {

            }
        }

        val nonWebMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.chrisbanes.haze)
            }
        }

        androidMain {
            dependsOn(nonWebMain)
        }

        val desktopMain by getting {
            dependsOn(nonWebMain)
            dependencies {
                implementation(compose.desktop.common)
            }
        }

        jsMain {

        }

        val wasmJsMain by getting {

        }
    }
}

android {

    namespace = "com.github.bkmbigo.glassmorphicprofilecard.common"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }
}

compose {

}
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    wasmJs {
        browser()
        binaries.executable()


        applyBinaryen {
            binaryenArgs = mutableListOf(
                "--enable-nontrapping-float-to-int",
                "--enable-gc",
                "--enable-reference-types",
                "--enable-exception-handling",
                "--enable-bulk-memory",
                "--inline-functions-with-loops",
                "--traps-never-happen",
                "--fast-math"
            )
        }
    }

    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.material3)
            }
        }
    }
}

compose.experimental {
    web.application {}
}
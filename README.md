# Glassmorphic Profile Card
A simple card that blurs the background.

The current [implementation](common/src/commonMain/kotlin/com/github/bkmbigo/glassmorphicprofilecard/common/presentation/screens/HazeProfileScreen.kt) uses the awesome library [Haze](https://chrisbanes.github.io/haze/)

https://github.com/BKMbigo/glassmorphic_profile_card/assets/102836149/e2abdb60-3384-4709-a823-3c644aadec97

The repository contains different versions of the library deployed in Android, desktop and web platforms.

### Challenges faces
1. ComposeResources does not copy resources declared in [commonMain](common/src/commonMain/composeResources) to respective platforms. This caused a runtime crash `MissingResourceException`". Workaround involved creating a copy of the resources in each platform.
2. Haze library had different behaviors between Jetpack Compose (android) and Compose Multiplatform targets. This led to a workaround that involved using an older version of the library `0.4.1` on android and version `0.5.0` in compose-multiplatform. Although the library does not support web targets, its dependencies are available on web-targets and therefore we can use the library on [Js](common/src/jsMain/kotlin/com/github/bkmbigo/glassmorphicprofilecard/common/presentation/utils) and [Wasm](common/src/wasmJsMain/kotlin/com/github/bkmbigo/glassmorphicprofilecard/common/presentation/utils) targets 

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.screens.HazeBackgroundScreen
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.theme.GlassmorphicProfileCardTheme


/* Crash: Uncaught TypeError: Module["org_jetbrains_skia_Paint__1nMake"] is not a function */
@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("Glassmorphic Profile") {
        GlassmorphicProfileCardTheme {
            HazeBackgroundScreen()
        }
    }
}

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.screens.HazeBackgroundScreen
import com.github.bkmbigo.glassmorphicprofilecard.common.presentation.theme.GlassmorphicProfileCardTheme

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Glassmorphic Profile Card"
    ) {
        GlassmorphicProfileCardTheme{
            HazeBackgroundScreen()
        }
    }
}
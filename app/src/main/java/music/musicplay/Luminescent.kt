package music.musicplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import music.musicplay.ui.theme.CrazyBerryTheme
import music.musicplay.ui.theme.LuminescentScene
import music.musicplay.ui.theme.QuintessentialScene

class Luminescent : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Settings activity

        setContent {
            CrazyBerryTheme {
                LuminescentScene()
            }
        }
    }

}
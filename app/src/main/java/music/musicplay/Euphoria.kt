package music.musicplay

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import music.musicplay.ui.theme.CrazyBerryTheme
import music.musicplay.ui.theme.EuphoriaScene

class Euphoria : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CrazyBerryTheme {
                EuphoriaScene()
            }
        }
    }

    fun navigateToQuintessential(){
        val intentQuintessential = Intent(this, Quintessential::class.java)
        startActivity(intentQuintessential)
    }

}
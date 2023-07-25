package music.musicplay

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import music.musicplay.ui.theme.CrazyBerryTheme
import music.musicplay.ui.theme.QuintessentialScene

class Quintessential : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CrazyBerryTheme {
                QuintessentialScene()
            }
        }
    }

    fun navigateToEuphoria(){
        val intentEuphoria = Intent(this, Euphoria::class.java)
        startActivity(intentEuphoria)
    }

    fun navigateToLuminescent(){
        val intentLuminescent = Intent(this, Luminescent::class.java)
        startActivity(intentLuminescent)
    }

    fun navigateToWhimsical(){
        val intentWhimsical = Intent(this, Whimsical::class.java)
        startActivity(intentWhimsical)
    }
}
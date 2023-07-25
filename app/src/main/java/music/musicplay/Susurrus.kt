package music.musicplay

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import music.musicplay.ui.theme.CrazyBerryTheme
import music.musicplay.ui.theme.SusurrusScene

class Susurrus : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CrazyBerryTheme {
                SusurrusScene()
            }
        }
    }

    fun navigateToQuintessential(){
        val intentQuintessential = Intent(this, Quintessential::class.java)
        startActivity(intentQuintessential)
    }

}


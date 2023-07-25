package music.musicplay.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import music.musicplay.Quintessential
import music.musicplay.R
import music.musicplay.Susurrus


@Composable
fun QuintessentialScene(){

    val activity = LocalContext.current as Quintessential


    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.surface),
            contentDescription = "surf",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        
        Image(
            painter = painterResource(id = R.drawable.halcyon),
            contentDescription = "7",
            modifier = Modifier
                .align(Alignment.BottomStart)
        )

        Image(
            painter = painterResource(id = R.drawable.incandescent),
            contentDescription = "r",
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )

        Image(
            painter = painterResource(id = R.drawable.ambrosia),
            contentDescription = "a",
            modifier = Modifier
                .align(Alignment.TopEnd)
        )
        
        Image(
            painter = painterResource(id = R.drawable.cacophony),
            contentDescription = "l",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(x = 128.dp, y = 128.dp)
        )
        
        Image(
            painter = painterResource(id = R.drawable.bumblebee),
            contentDescription = "b",
            modifier = Modifier
                .align(Alignment.TopStart)
                .alpha(0.5f)
        )

        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 72.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.effervescent),
                    contentDescription = "btn",
                    modifier = Modifier
                        .align(Alignment.Center)
                )
                
                Text(
                    text = "New game",
                    color = CrazyWhite,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            activity.navigateToEuphoria()
                        }
                )
            }

            Box(modifier = Modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(id = R.drawable.effervescent),
                    contentDescription = "btn",
                    modifier = Modifier
                        .align(Alignment.Center)
                )

                Text(
                    text = "Settings",
                    color = CrazyWhite,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            activity.navigateToLuminescent()
                        }
                )
            }

            Box(modifier = Modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(id = R.drawable.effervescent),
                    contentDescription = "btn",
                    modifier = Modifier
                        .align(Alignment.Center)
                )

                Text(
                    text = "Rules",
                    color = CrazyWhite,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            activity.navigateToWhimsical()
                        }
                )
            }
        }
    }
}
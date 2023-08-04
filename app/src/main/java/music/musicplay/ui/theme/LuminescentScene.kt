package music.musicplay.ui.theme

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import music.musicplay.R
import music.musicplay.Stab


@Composable
fun LuminescentScene(){

    //Settings screen

    val context = LocalContext.current
    val sp = context.getSharedPreferences(Stab.SHARE, Context.MODE_PRIVATE)

    val name = remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.surface),
            contentDescription = "surf",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Enter your name",
            color = CrazyWhite,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = -32.dp)
        )

        BasicTextField(
            value = name.value,
            textStyle = TextStyle(color = CrazyWhite, textAlign = TextAlign.Center),
            modifier = Modifier
                .width(256.dp)
                .border(BorderStroke(1.dp, CrazyWhite), shape = RoundedCornerShape(4.dp))
                .align(Alignment.Center),
            onValueChange = {
                val newValue = it.replace("\n", "")
                name.value = newValue
                sp.edit().putString(Stab.SHARE_USER_NAME, newValue).apply()
            }
        )
    }

}


@Composable
@Preview
fun PrevLum(){
    LuminescentScene()
}
package music.musicplay.ui.theme

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import music.musicplay.R
import music.musicplay.Stab
import music.musicplay.prescrazy.CrazyViewModel


@Composable
fun EuphoriaScene() {
    //Game

    val crazyViewModel = viewModel<CrazyViewModel>()
    val scores = crazyViewModel.existenceScores.collectAsState()


    LaunchedEffect(Unit){
        crazyViewModel.initialStateOfNewGame()
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.surface),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Gameplay(crazyViewModel)
        Scores(scores = scores.value)
    }
}
@Composable
fun BoxScope.Scores(scores: Int){
    Box(modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.TopCenter)){

        Image(
            painter = painterResource(id = R.drawable.serendipity),
            contentDescription = "scores background",
            modifier = Modifier
                .align(Alignment.Center)
        )

        Text(
            text = "$scores scores",
            color = CrazyWhite,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun BoxScope.Gameplay(vm: CrazyViewModel){

    val crazyList = vm.existenceList.collectAsState()
    val existenceLives = vm.existenceLives.collectAsState()
    val existenceTime = vm.existenceTime.collectAsState()
    val context = LocalContext.current
    val sp = context.getSharedPreferences(Stab.SHARE, Context.MODE_PRIVATE)
    val username = sp.getString(Stab.SHARE_USER_NAME, "user")
    
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .align(Alignment.Center),
        columns = GridCells.Fixed(4),
        content = {
            items(16){
                Image(
                    painter = painterResource(id = if(crazyList.value[it].starMenu.boolean) crazyList.value[it].scenePicture else crazyList.value[it].background),
                    contentDescription = "play",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            vm.touchElement(it)
                        }
                )
            }
        }
    )

    Text(
        text = "Time: ${existenceTime.value}",
        color = CrazyWhite,
        modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(bottom = 16.dp)
    )

    Text(
        text = "Hello $username",
        color = CrazyWhite,
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 16.dp)

    )


    when (existenceLives.value) {
        2 -> {
            Row(modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 16.dp)

            ) {

                Image(
                    painter = painterResource(id = R.drawable.petrichor),
                    contentDescription = "lives",
                    modifier = Modifier.size(32.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.petrichor),
                    contentDescription = "lives",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
        1 -> {
            Row(modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 16.dp)

            ) {

                Image(
                    painter = painterResource(id = R.drawable.petrichor),
                    contentDescription = "lives",
                    modifier = Modifier.size(32.dp)
                )
            }
        }
        else -> {

            //Game over
            GameOverScreen()

        }
    }
}


@Composable
fun BoxScope.GameOverScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = "Game Over",
            color = CrazyWhite,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
package music.musicplay.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import music.musicplay.R
import music.musicplay.prescrazy.CrazyViewModel


@Composable
fun EuphoriaScene() {
    //Game

    val crazyViewModel = viewModel<CrazyViewModel>()

    val scores = crazyViewModel.existenceScores.collectAsState()

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
    
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .align(Alignment.Center),
        columns = GridCells.Fixed(4),
        content = {
            items(16){
                Image(
                    painter = painterResource(id = crazyList.value[it].scenePicture),
                    modifier = Modifier.padding(16.dp),
                    contentDescription = "play"
                )
            }
        }
    )
}
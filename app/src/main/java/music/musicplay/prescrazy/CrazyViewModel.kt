package music.musicplay.prescrazy

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import music.musicplay.R
import music.musicplay.domain.AdditionalState
import music.musicplay.domain.PlayByte
import music.musicplay.domain.StarMenu


class CrazyViewModel : ViewModel() {

    val existenceList: MutableStateFlow<List<PlayByte>> = MutableStateFlow(listOf(
        PlayByte(0, scenePicture = R.drawable.bumblebee, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(1, scenePicture = R.drawable.nebulous, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(2, scenePicture = R.drawable.quixotic, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(3, scenePicture = R.drawable.incandescent, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),

        PlayByte(4, scenePicture = R.drawable.luminous, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(5, scenePicture = R.drawable.bumblebee, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(6, scenePicture = R.drawable.quixotic, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(7, scenePicture = R.drawable.incandescent, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),

        PlayByte(8, scenePicture = R.drawable.luminous, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(9, scenePicture = R.drawable.nebulous, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(10, scenePicture = R.drawable.bumblebee, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(11, scenePicture = R.drawable.incandescent, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),

        PlayByte(12, scenePicture = R.drawable.luminous, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(13, scenePicture = R.drawable.nebulous, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(14, scenePicture = R.drawable.quixotic, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
        PlayByte(15, scenePicture = R.drawable.bumblebee, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(false)),
    ))


}
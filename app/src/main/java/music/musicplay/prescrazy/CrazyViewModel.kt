package music.musicplay.prescrazy

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import music.musicplay.R
import music.musicplay.domain.AdditionalState
import music.musicplay.domain.PlayByte
import music.musicplay.domain.StarMenu


class CrazyViewModel : ViewModel() {

    val existenceScores : MutableStateFlow<Int> = MutableStateFlow(0)
    val existenceLives : MutableStateFlow<Int> = MutableStateFlow(2)
    val existenceTime : MutableStateFlow<Int> = MutableStateFlow(20)

    var choiceImage: Int? = null
    var choicePosition: Int? = null

    val existenceList: MutableStateFlow<List<PlayByte>> = MutableStateFlow(listOf(
        PlayByte(0, scenePicture = R.drawable.bumblebee, background = R.drawable.petrichor, additionalState = AdditionalState("serendipity"), starMenu = StarMenu(true)),
        PlayByte(1, scenePicture = R.drawable.nebulous, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(true)),
        PlayByte(2, scenePicture = R.drawable.quixotic, background = R.drawable.petrichor, additionalState = AdditionalState("luminous"), starMenu = StarMenu(true)),
        PlayByte(3, scenePicture = R.drawable.incandescent, background = R.drawable.petrichor, additionalState = AdditionalState("mellifluous"), starMenu = StarMenu(true)),

        PlayByte(4, scenePicture = R.drawable.luminous, background = R.drawable.petrichor, additionalState = AdditionalState("nebulous"), starMenu = StarMenu(true)),
        PlayByte(5, scenePicture = R.drawable.bumblebee, background = R.drawable.petrichor, additionalState = AdditionalState("mellifluous"), starMenu = StarMenu(true)),
        PlayByte(6, scenePicture = R.drawable.quixotic, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(true)),
        PlayByte(7, scenePicture = R.drawable.incandescent, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(true)),

        PlayByte(8, scenePicture = R.drawable.luminous, background = R.drawable.petrichor, additionalState = AdditionalState("onomatopoeia"), starMenu = StarMenu(true)),
        PlayByte(9, scenePicture = R.drawable.nebulous, background = R.drawable.petrichor, additionalState = AdditionalState("cacophony"), starMenu = StarMenu(true)),
        PlayByte(10, scenePicture = R.drawable.bumblebee, background = R.drawable.petrichor, additionalState = AdditionalState("petrichor"), starMenu = StarMenu(true)),
        PlayByte(11, scenePicture = R.drawable.incandescent, background = R.drawable.petrichor, additionalState = AdditionalState("onomatopoeia"), starMenu = StarMenu(true)),

        PlayByte(12, scenePicture = R.drawable.luminous, background = R.drawable.petrichor, additionalState = AdditionalState("cacophony"), starMenu = StarMenu(true)),
        PlayByte(13, scenePicture = R.drawable.nebulous, background = R.drawable.petrichor, additionalState = AdditionalState("ephemeral"), starMenu = StarMenu(true)),
        PlayByte(14, scenePicture = R.drawable.quixotic, background = R.drawable.petrichor, additionalState = AdditionalState("nebulous"), starMenu = StarMenu(true)),
        PlayByte(15, scenePicture = R.drawable.bumblebee, background = R.drawable.petrichor, additionalState = AdditionalState("halcyon"), starMenu = StarMenu(true)),
    ))

    suspend fun initialStateOfNewGame(){
        val shuffledList = existenceList.value.shuffled()
        existenceList.value = shuffledList

        delay(1500)
        val newList = existenceList.value.map {
            it.copy(starMenu = StarMenu(false))
        }

        existenceList.value = newList

        while (existenceTime.value>0){
            delay(1000)
            existenceTime.value -= 1
        }
    }

    fun touchElement(position: Int){
        val newList = existenceList.value.toMutableList()
        newList[position] = newList[position].copy(starMenu = StarMenu(true))
        existenceList.value = newList
        checkBomb(position)
        checkScore(position)
    }

    private fun checkScore(position: Int) {
        when(existenceList.value[position].scenePicture){
            R.drawable.bumblebee -> {
                minusScore(2)
            }

            else -> {
                checkPair(position)
            }
        }
    }

    private fun checkPair(position: Int) {
        if (choiceImage == null){
            choiceImage = existenceList.value[position].scenePicture
            choicePosition = position
        } else {
            if (choiceImage == existenceList.value[position].scenePicture){
                addScores(position)
                choiceImage = null
                choicePosition = null
            } else {

                viewModelScope.launch {
                    closeElements(position, choicePosition!!)
                }
                choiceImage = null
                choicePosition = null
            }
        }
    }

    private suspend fun closeElements(position: Int, choicePosition: Int) {
        delay(600)
        val newList = existenceList.value.toMutableList()
        newList[position] = newList[position].copy(starMenu = StarMenu(false))
        newList[choicePosition] = newList[choicePosition].copy(starMenu = StarMenu(false))
        existenceList.value = newList

    }

    private fun addScores(position: Int){
        when(existenceList.value[position].scenePicture){
            R.drawable.nebulous -> {
                val newScore = existenceScores.value + 1
                existenceScores.value = newScore
            }
            R.drawable.quixotic -> {
                val newScore = existenceScores.value + 2
                existenceScores.value = newScore
            }
            R.drawable.incandescent -> {
                val newScore = existenceScores.value + 3
                existenceScores.value = newScore
            }
            R.drawable.luminous -> {
                val newScore = existenceScores.value + 4
                existenceScores.value = newScore
            }
        }
    }

    private fun minusScore(score: Int){
        if (existenceScores.value != 0){
            val newScoresWithMinus = existenceScores.value - score
            existenceScores.value = newScoresWithMinus
        }
    }

    private fun checkBomb(position: Int) {
        if (existenceList.value[position].scenePicture == R.drawable.bumblebee){
            val newExistLife = existenceLives.value - 1
            existenceLives.value = newExistLife
        }
    }
}
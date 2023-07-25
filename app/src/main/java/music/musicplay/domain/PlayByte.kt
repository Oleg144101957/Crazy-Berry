package music.musicplay.domain

data class PlayByte (
    val identificator: Int,
    val scenePicture: Int,
    val background: Int,
    val additionalState: AdditionalState,
    val starMenu: StarMenu
)
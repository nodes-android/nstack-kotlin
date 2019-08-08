package dk.nodes.nstack.kotlin.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Optional

@Serializable
data class RateReminder(

    @SerialName("body")
    val body: String,

    @SerialName("laterBtn")
    val laterBtn: String,

    @SerialName("link")
    val link: String,

    @SerialName("noBtn")
    val noBtn: String,

    @SerialName("title")
    val title: String,

    @SerialName("yesBtn")
    val yesBtn: String
)
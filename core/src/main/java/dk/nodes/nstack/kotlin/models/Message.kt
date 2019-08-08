package dk.nodes.nstack.kotlin.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Optional

@Serializable
data class Message(

    @SerialName("id")
    val id: Int,

    @SerialName("message")
    val message: String,

    @SerialName("show_setting")
    val showSetting: String
)
package dk.nodes.nstack.kotlin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateTranslate(
    @SerialName("message")
    val message: String,
    @SerialName("positiveBtn")
    val positiveBtn: String,
    @SerialName("title")
    val title: String
)
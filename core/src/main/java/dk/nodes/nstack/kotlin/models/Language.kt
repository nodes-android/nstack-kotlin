package dk.nodes.nstack.kotlin.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Optional

@Serializable
data class Language(

    @SerialName("direction")
    val direction: String,

    @SerialName("id")
    val id: Int,

    @SerialName("is_best_fit")
    val isBestFit: Boolean,

    @SerialName("is_default")
    val isDefault: Boolean,

    @SerialName("locale")
    val locale: String,

    @SerialName("name")
    val name: String
)
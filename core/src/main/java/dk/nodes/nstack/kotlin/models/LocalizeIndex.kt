package dk.nodes.nstack.kotlin.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocalizeIndex(

    @SerialName("id")
    val id: Int,

    @SerialName("language")
    val language: Language,

    @SerialName("last_updated_at")
    val lastUpdatedAt: String,

    @SerialName("should_update")
    val shouldUpdate: Boolean,

    @SerialName("url")
    val url: String
)
package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

@Serializable
data class UpdateTranslate(
    val title: String,
    val message: String,
    val positiveBtn: String,
    val negativeBtn: String
)

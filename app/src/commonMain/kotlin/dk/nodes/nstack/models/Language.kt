package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

@Serializable
data class Language(
    val id: Int,
    val name: String,
    val locale: String,
    val direction: String,
    val is_default: Boolean,
    val is_best_fit: Boolean
)

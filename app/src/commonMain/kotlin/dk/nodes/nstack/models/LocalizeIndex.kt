package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

@Serializable
data class LocalizeIndex(
    val id: Int,
    val url: String,
    val last_updated_at: String,
    val should_update: Boolean,
    val language: Language
)
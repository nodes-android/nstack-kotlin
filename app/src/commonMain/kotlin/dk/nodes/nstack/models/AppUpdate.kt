package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

@Serializable
data class AppUpdate(
    val state: String = "",
    val update: Update? = null
)
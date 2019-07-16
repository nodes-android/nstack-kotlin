package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

@Serializable
data class AppUpdateMeta(
    val accept_Language: String?
)
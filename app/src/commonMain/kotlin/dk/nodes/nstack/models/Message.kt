package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val id: Int,
    val project_id: Int,
    val platform: String,
    val show_setting: String,
    val view_count: Int,
    val message: String
)




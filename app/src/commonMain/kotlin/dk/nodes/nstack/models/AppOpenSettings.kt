package dk.nodes.nstack.models

data class AppOpenSettings(
    val platform: String,
    val guid: String,
    val version: String,
    val old_version: String,
    val last_updated: String
)

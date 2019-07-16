package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

@Serializable
data class AppUpdateData(
    val count: Int = 0,
    val update: AppUpdate = AppUpdate(),
    val localize: List<LocalizeIndex> = listOf(),
    val platform: String = "",
    val created_at: String,
    val last_updated: String,
    val message: Message? = null,
    val rate_reminder: RateReminder? = null
)
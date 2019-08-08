package dk.nodes.nstack.kotlin.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppUpdateData(
    @SerialName("count")
    val count: Int = 0,
    @SerialName("created_at")
    val createdAt: String = "",
    @SerialName("last_updated")
    val lastUpdated: String = "",
    @SerialName("localize")
    val localize: List<LocalizeIndex> = listOf(),
    @SerialName("message")
    val message: Message? = null,
    @SerialName("platform")
    val platform: String = "",
    @SerialName("rate_reminder")
    val rateReminder: RateReminder? = null,
    @SerialName("update")
    val update: AppUpdate? = null
)
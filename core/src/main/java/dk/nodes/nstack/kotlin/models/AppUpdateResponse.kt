package dk.nodes.nstack.kotlin.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppUpdateResponse(
    @SerialName("data")
    val data: AppUpdateData,
    @SerialName("meta")
    val meta: AppUpdateMeta
)
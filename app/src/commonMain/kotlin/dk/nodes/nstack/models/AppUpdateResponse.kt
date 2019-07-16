package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

@Serializable
data class AppUpdateResponse(
    val data: AppUpdateData,
    val meta: AppUpdateMeta
)

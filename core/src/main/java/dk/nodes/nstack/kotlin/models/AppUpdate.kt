package dk.nodes.nstack.kotlin.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppUpdate(

    @SerialName("newer_version")
    val newerVersion: Update
)
package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

/**
 * Info for rate reminder dialog
 */

@Serializable
data class RateReminder(
    val title: String,
    val body: String,
    val yesBtn: String,
    val laterBtn: String,
    val noBtn: String,
    val link: String
)

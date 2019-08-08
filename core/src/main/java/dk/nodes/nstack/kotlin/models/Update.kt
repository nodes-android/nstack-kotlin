package dk.nodes.nstack.kotlin.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Update(

    @SerialName("file_url")
    val fileUrl: String?,

    @SerialName("last_id")
    val lastId: Int,

    @SerialName("link")
    val link: String,

    @SerialName("state")
    val state: String,

    @SerialName("translate")
    val translate: UpdateTranslate,

    @SerialName("version")
    val version: String
)
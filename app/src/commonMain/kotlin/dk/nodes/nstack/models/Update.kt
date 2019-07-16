package dk.nodes.nstack.models


data class Update(
    val state: String = "none",
    val last_id: Int,
    val version: String,
    val link: String,
    val translate: UpdateTranslate
)


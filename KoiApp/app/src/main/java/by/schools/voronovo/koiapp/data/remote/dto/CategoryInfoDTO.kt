package by.schools.voronovo.koiapp.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryInfoDTO(
    val isGenerator: Boolean,
    val nodes: Map<String, String>,     //path - title
    val title: String?
)
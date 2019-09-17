package by.schools.voronovo.koiapp.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class QuestionDTO(
    val allOptions: List<String>,
    val correctAnswer: String,
    val expression: String
)
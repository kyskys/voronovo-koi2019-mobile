package by.schools.voronovo.koiapp.data.remote.api

import by.schools.voronovo.koiapp.data.remote.dto.CategoryInfoDTO
import by.schools.voronovo.koiapp.data.remote.dto.QuestionDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("categories")
    suspend fun getRootCategoryInfo() : CategoryInfoDTO

    @GET("categories/{segments}")
    suspend fun getCategoryInfo(@Path(value = "segments", encoded = true) categories: String) : CategoryInfoDTO

    @GET("categories/{segments}/generate")
    suspend fun generateQuestion(@Path(value = "segments", encoded = true) categories: String) : QuestionDTO
}
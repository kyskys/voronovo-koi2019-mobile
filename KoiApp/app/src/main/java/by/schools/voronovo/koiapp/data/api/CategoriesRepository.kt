package by.schools.voronovo.koiapp.data.api

import by.schools.voronovo.koiapp.model.CategoryInfo

interface CategoriesRepository {
    suspend fun getCategoryInfo(categories: Collection<String>) : CategoryInfo
}
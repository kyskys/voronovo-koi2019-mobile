package by.schools.voronovo.koiapp.data.impl

import by.schools.voronovo.koiapp.data.api.CategoriesRepository
import by.schools.voronovo.koiapp.data.toModel
import by.schools.voronovo.koiapp.data.remote.api.Api
import by.schools.voronovo.koiapp.model.CategoryInfo

class CategoriesRepositoryImpl(
    private val api: Api
) : CategoriesRepository {

    override suspend fun getCategoryInfo(categories: Collection<String>): CategoryInfo {
        val dto = if (categories.isEmpty()) {
            api.getRootCategoryInfo()
        } else {
            api.getCategoryInfo(categories = categories.joinToString("/"))
        }
        return dto.toModel()
    }
}
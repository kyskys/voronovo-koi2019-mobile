package by.schools.voronovo.koiapp.data

import by.schools.voronovo.koiapp.data.remote.dto.CategoryInfoDTO
import by.schools.voronovo.koiapp.model.CategoryInfo

fun CategoryInfoDTO.toModel(): CategoryInfo {
    return CategoryInfo(
        title = title,
        isGenerator = isGenerator,
        childrenInfo = nodes
    )
}

fun CategoryInfo.toDto() : CategoryInfoDTO {
    return CategoryInfoDTO(
        title = title,
        isGenerator = isGenerator,
        nodes = childrenInfo
    )
}
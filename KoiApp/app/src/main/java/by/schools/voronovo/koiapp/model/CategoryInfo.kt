package by.schools.voronovo.koiapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryInfo(
    val title: String?,
    val isGenerator: Boolean,
    val childrenInfo: Map<String, String>
) : Parcelable
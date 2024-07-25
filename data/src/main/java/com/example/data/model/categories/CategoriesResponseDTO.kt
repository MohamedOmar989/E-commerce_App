package com.example.data.model.categories

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoriesResponseDTO(

    val metadata: MetadataDTO? = null,

    val data: List<CategoryItemDTO?>? = null,

    val results: Int? = null,

    val statusMsg:String? = null,

    val message: String? =null
) : Parcelable
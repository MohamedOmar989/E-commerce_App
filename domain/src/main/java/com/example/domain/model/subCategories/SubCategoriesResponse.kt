package com.example.domain.model.subCategories

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class SubCategoriesResponse(

    val metadata: com.example.domain.model.subCategories.Metadata? = null,

    val data: List<com.example.domain.model.subCategories.SubCategoryItem?>? = null,

    val results: Int? = null
) : Parcelable

package com.example.domain.model.categories

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class CategoriesResponse(

    val metadata: com.example.domain.model.categories.Metadata? = null,

    val data: List<com.example.domain.model.categories.CategoryItem?>? = null,

    val results: Int? = null,

    val statusMsg:String? = null,

    val message: String? =null
) : Parcelable

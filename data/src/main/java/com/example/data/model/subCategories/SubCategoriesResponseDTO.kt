package com.example.data.model.subCategories

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class SubCategoriesResponseDTO(

    @field:SerializedName("subCategoriesMetadata")
    val subCategoriesMetadata: SubCategoriesMetadata? = null,


    val data: List<SubCategoryItemDTO?>? = null,

    @field:SerializedName("results")
    val results: Int? = null
) : Parcelable
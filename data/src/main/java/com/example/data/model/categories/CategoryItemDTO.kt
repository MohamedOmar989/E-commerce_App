package com.example.data.model.categories

import android.os.Parcelable
import com.example.domain.model.categories.CategoryItem
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryItemDTO(

    val image: String? = null,

    val createdAt: String? = null,

    val name: String? = null,

    @SerializedName("_id")
    val id: String? = null,

    val slug: String? = null,

    val updatedAt: String? = null
) : Parcelable {

    fun toCategory(): CategoryItem {

        return CategoryItem(image, createdAt, name, id, slug, updatedAt)
    }
}
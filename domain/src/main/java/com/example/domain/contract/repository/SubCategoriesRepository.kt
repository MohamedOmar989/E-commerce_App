package com.example.domain.contract.repository


import com.example.domain.model.subCategories.SubCategoryItem

interface SubCategoriesRepository {

    suspend fun getAllSubCategoriesOnCategory(id: String): List<SubCategoryItem?>?

}
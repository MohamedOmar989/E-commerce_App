package com.example.data.repository

import com.example.domain.contract.dataSource.OnlineDataSource
import com.example.domain.contract.repository.SubCategoriesRepository
import com.example.domain.model.subCategories.SubCategoryItem
import javax.inject.Inject

class SubCategoriesRepoImpl @Inject constructor(private val onlineDataSource: OnlineDataSource): SubCategoriesRepository {

    override suspend fun getAllSubCategoriesOnCategory(id: String): List<SubCategoryItem?>? {

        return onlineDataSource.getAllSubCategoriesOnCategory(id)
    }
}
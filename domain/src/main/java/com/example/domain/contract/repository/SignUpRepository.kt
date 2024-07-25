package com.example.domain.contract.repository

import com.example.domain.model.UserData
import com.example.domain.model.UserDataResponse
import com.example.domain.model.categories.CategoryItem
import com.example.domain.model.signin.SignInResponse

interface SignUpRepository {

    suspend fun signUp(userData: UserData): UserDataResponse

    suspend fun signIn(userData: UserData): SignInResponse

    suspend fun getAllCategories(): List<CategoryItem?>?


}
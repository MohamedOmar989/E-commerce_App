package com.example.domain.model.products

data class ProductsInCategoryResponse(

    val metadata: com.example.domain.model.products.ProductsMetadata? = null,

    val data: List<com.example.domain.model.products.ProductItem?>? = null,

    val results: Int? = null
)
package com.example.domain.model.products

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ProductItem(

    val sold: Int? = null,

    val images: List<String?>? = null,

    val quantity: Int? = null,

    val availableColors: @RawValue List<Any?>? = null,

    val imageCover: String? = null,

    val description: String? = null,

    val title: String? = null,

    val ratingsQuantity: Int? = null,

    val ratingsAverage: @RawValue Any? = null,

    val createdAt: String? = null,

    val price: Int? = null,

    val _id: String? = null,

    val id: String? = null,

    val subcategory: List<com.example.domain.model.products.SubcategoryItem?>? = null,

    val category: com.example.domain.model.products.Category? = null,

    val brand: com.example.domain.model.products.Brand? = null,

    val slug: String? = null,

    val updatedAt: String? = null,

    val priceAfterDiscount: Int? = null,

    val __v:@RawValue Any? = null
):Parcelable
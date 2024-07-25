package com.example.data.model.categories

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MetadataDTO(

    val numberOfPages: Int? = null,

    val limit: Int? = null,

    val currentPage: Int? = null
) : Parcelable
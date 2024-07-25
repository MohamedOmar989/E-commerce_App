package com.example.data.model.userData

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDataDTO(
    val uid : String? = null,
    val firstName : String? = null,
    val email : String? = null,
    val phone: String? = null,
    val rePassword: String? = null,
): Parcelable

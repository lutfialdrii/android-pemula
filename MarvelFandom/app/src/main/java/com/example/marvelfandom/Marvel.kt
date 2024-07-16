package com.example.marvelfandom

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Marvel(
    val name: String,
    val alias: String,
    val history: String,
    val photo: String,
    val category: String,
    val description: String,
    val age: Int
) : Parcelable

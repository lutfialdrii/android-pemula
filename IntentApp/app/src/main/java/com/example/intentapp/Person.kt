package com.example.intentapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// tambahkan plugin id("kotlin-parcelize") pada build.gradle Module:app
@Parcelize
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable

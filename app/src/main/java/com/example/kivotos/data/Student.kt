package com.example.kivotos.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Student(
    val id: Long,
    @StringRes val name:Int,
    //val school: School,
    @DrawableRes val avatar:Int,
    @StringRes val hobbies:Int
)
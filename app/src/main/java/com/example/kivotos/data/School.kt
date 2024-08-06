package com.example.kivotos.data

import androidx.annotation.DrawableRes

data class School(
    val id: Int,
    val schoolName: Int = -1,
    val academy: AcademyType,
    val studentList: List<Student>,
    @DrawableRes val imageId:Int
)
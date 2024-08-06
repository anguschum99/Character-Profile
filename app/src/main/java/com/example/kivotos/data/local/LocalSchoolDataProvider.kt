package com.example.kivotos.data.local

import com.example.kivotos.R
import com.example.kivotos.data.AcademyType
import com.example.kivotos.data.School

object LocalSchoolDataProvider {

    fun getSchoolData(): List<School> {
        return listOf(
            School(
                id = 1,
                schoolName = R.string.Abydos,
                academy = AcademyType.ABYDOS,
                studentList = LocalStudentDataProvider.abydosList,
                imageId = R.drawable.abydos_icon_webp
            ),
            School(
                id = 2,
                schoolName = R.string.Arius,
                academy = AcademyType.ARIUS,
                studentList = LocalStudentDataProvider.ariusList,
                imageId = R.drawable.arius_icon_webp
            ),
            School(
                id = 3,
                schoolName = R.string.Gehenna,
                academy = AcademyType.GEHENNA,
                studentList = LocalStudentDataProvider.gehennaList,
                imageId = R.drawable.gehenna_icon
            ),
            School(
                id = 4,
                schoolName = R.string.Trinity,
                academy = AcademyType.TRINITY,
                studentList = LocalStudentDataProvider.trinityList,
                imageId = R.drawable.trinity_icon_webp
            ),
            School(
                id = 5,
                schoolName = R.string.Millennium,
                academy = AcademyType.MILLENIUM,
                studentList = LocalStudentDataProvider.millenniumList,
                imageId = R.drawable.millennium_icon_webp
            ),
            School(
                id = 6,
                schoolName = R.string.Red_Winter,
                academy = AcademyType.RED_WINTER,
                studentList = LocalStudentDataProvider.redwinterList,
                imageId = R.drawable.red_winter_icon_webp
            ),
            School(
                id = 7,
                schoolName = R.string.Shanhaijing,
                academy = AcademyType.SHANHAIJING,
                studentList = LocalStudentDataProvider.shanhaijingList,
                imageId = R.drawable.shanhaijing_icon_webp
            ),
            School(
                id = 8,
                schoolName = R.string.Valkyrie,
                academy = AcademyType.VALKYRIE,
                studentList = LocalStudentDataProvider.valkyrieList,
                imageId = R.drawable.valkyrie_icon_webp
            ),
        )
    }


    private val allSchools = listOf(
        School(
            id = 1,
            schoolName = R.string.Abydos,
            academy = AcademyType.ABYDOS,
            studentList = LocalStudentDataProvider.abydosList,
            imageId = R.drawable.abydos_icon_webp
        ),
        School(
            id = 2,
            schoolName = R.string.Arius,
            academy = AcademyType.ARIUS,
            studentList = LocalStudentDataProvider.ariusList,
            imageId = R.drawable.arius_icon_webp
        ),

        )

    val frog = allSchools[0]


}
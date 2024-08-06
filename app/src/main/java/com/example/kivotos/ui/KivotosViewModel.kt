package com.example.kivotos.ui

import androidx.lifecycle.ViewModel
import com.example.kivotos.data.School
import com.example.kivotos.data.Student
import com.example.kivotos.data.local.LocalSchoolDataProvider
import com.example.kivotos.data.local.LocalStudentDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class KivotosViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        KivotosUiState(
            schoolsList = LocalSchoolDataProvider.getSchoolData(),
            currentSchool = LocalSchoolDataProvider.getSchoolData().getOrElse(0) {
                LocalSchoolDataProvider.frog
            }
        )
    )
    val uiState: StateFlow<KivotosUiState> = _uiState

    fun updateCurrentSchool(selectedSchool: School) {
        _uiState.update {
            it.copy(currentSchool = selectedSchool)
        }
    }

    fun getStudentList(selectedSchool: School){
        _uiState.update {
            it.copy(studentList = selectedSchool.studentList)
        }
    }

    fun updateCurrentStudent(selectedStudent: Student) {
        _uiState.update {
            it.copy(currentStudent = selectedStudent)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true,)
        }
    }

    fun navigateToStudentPage() {
        _uiState.update {
            it.copy(isShowingListPage = false,
                isShowingStudentListPage = true,
                isShowingDetailsPage = false
            )
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false,
                isShowingStudentListPage = false,
                isShowingDetailsPage = true
                )
        }
    }


}

data class KivotosUiState(
    val schoolsList: List<School> = LocalSchoolDataProvider.getSchoolData(),
    val studentList: List<Student> = LocalStudentDataProvider.abydosList,
    val currentSchool: School = LocalSchoolDataProvider.frog,
    val currentStudent: Student = LocalStudentDataProvider.abydosList[0],
    val isShowingListPage: Boolean = true,
    val isShowingStudentListPage: Boolean = false,
    val isShowingDetailsPage: Boolean = false
)
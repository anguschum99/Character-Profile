package com.example.kivotos.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kivotos.R
import com.example.kivotos.ui.utils.WindowStateUtils

@Composable
fun KivotosApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier
) {
    val viewModel: KivotosViewModel = viewModel()
    val studentUiState = viewModel.uiState.collectAsState().value
    val contentType: WindowStateUtils

    when (windowSize) {
        WindowWidthSizeClass.Expanded -> {
            contentType = WindowStateUtils.ListAndDetail
        }

        else -> {
            contentType = WindowStateUtils.ListOnly
        }
    }

    if (contentType == WindowStateUtils.ListAndDetail) {
        if (studentUiState.isShowingListPage){
            KivotosListAndDetail(
                uiState = studentUiState,
                students = studentUiState.studentList,
                schools = studentUiState.schoolsList,
                onSchoolClick = {
                    viewModel.updateCurrentSchool(it)
                    viewModel.getStudentList(it)
                },
                onStudentClick = {
                    viewModel.updateCurrentStudent(it)
                    viewModel.navigateToDetailPage()
                }
            )
        }

        else if (studentUiState.isShowingDetailsPage) {
            DetailScreen(
                uiState = studentUiState,
                onBackPressed = { viewModel.navigateToListPage() })
        }

    } else {
        if (studentUiState.isShowingListPage) {
            SchoolList(
                schools = studentUiState.schoolsList,
                onClick = {
                    viewModel.updateCurrentSchool(it)
                    viewModel.navigateToStudentPage()
                    viewModel.getStudentList(it)
                },

                )
        } else if (studentUiState.isShowingStudentListPage) {
            StudentList(
                students = studentUiState.studentList,
                onClick = {
                    viewModel.updateCurrentStudent(it)
                    viewModel.navigateToDetailPage()
                },
                onBackClicked = { viewModel.navigateToListPage() }
            )
        } else {
            DetailScreen(
                uiState = studentUiState,
                onBackPressed = { viewModel.navigateToStudentPage() })
        }
    }


}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun KivotosAppBar(
//    onBackButtonClick: () -> Unit,
//    isShowingSchoolsPage: Boolean,
//    isShowingStudentsPage: Boolean,
//    isShowingDetailspage:Boolean,
//    modifier: Modifier = Modifier
//) {
//    CenterAlignedTopAppBar(
//        title = {
//            Text(
//                text =
//                if (isShowingSchoolsPage) {
//                    stringResource(R.string.blue_archive)
//                } else if (isShowingStudentsPage) {
//                    stringResource(R.string.students)
//                } else {
//                    stringResource(R.string.details)
//                }
//            )
//        },
//        navigationIcon = {
//            if (!isShowingSchoolsPage) {
//                IconButton(onClick = onBackButtonClick) {
//                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
//                }
//            }
//        }
//    )
//}
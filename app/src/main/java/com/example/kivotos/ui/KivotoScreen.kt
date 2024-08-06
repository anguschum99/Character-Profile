package com.example.kivotos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kivotos.data.School
import com.example.kivotos.data.Student
import com.example.kivotos.data.local.LocalSchoolDataProvider
import com.example.kivotos.data.local.LocalStudentDataProvider

@Composable
fun StudentList(
    students: List<Student>,
    onClick: (Student) -> Unit,
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp),
    onBackClicked: () -> Unit
) {
    Scaffold(
        topBar = { StudentTopBar(onBackClicked = onBackClicked) }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = contentPaddingValues,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .padding(innerPadding)
        ) {
            items(students, key = { student -> student.id }) { student ->
                StudentListItem(
                    student = student,
                    onItemClick = onClick
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentTopBar(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Students"
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClicked) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        }
    )
}


@Composable
private fun StudentListItem(
    student: Student,
    onItemClick: (Student) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        onClick = { onItemClick(student) },
    ) {
        Row {
            Image(
                painter = painterResource(id = student.avatar),
                contentDescription = null,
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(id = student.name),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = stringResource(id = student.hobbies),
                    style = MaterialTheme.typography.bodyMedium
                )

            }
        }
    }
}


@Composable
fun KivotosListAndDetail(
    uiState: KivotosUiState,
    students: List<Student>,
    schools: List<School>,
    onSchoolClick: (School) -> Unit,
    onStudentClick: (Student) -> Unit,
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp)
) {
    Scaffold(
        topBar = { ListAndDetailTopAppBar() }
    ) { innerPadding ->
        Row(
            modifier = modifier.padding(innerPadding),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            LazyColumn(
                contentPadding = contentPaddingValues,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                items(schools, key = { school -> school.id }) { school ->
                    SchoolListItem(school = school, onCardClick = onSchoolClick)
                }
            }

            LazyColumn(
                contentPadding = contentPaddingValues,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                items(students, key = { student -> student.id }) { student ->
                    StudentListItem(student = student, onItemClick = onStudentClick)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListAndDetailTopAppBar(){
    CenterAlignedTopAppBar(title = { Text(text = "Blue Archive") })
}

@Preview
@Composable
fun StudentListPreview() {
    StudentList(students = LocalStudentDataProvider.abydosList, onClick = {}, onBackClicked = {})
}
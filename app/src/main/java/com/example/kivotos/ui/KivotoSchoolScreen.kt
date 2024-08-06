package com.example.kivotos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kivotos.R
import com.example.kivotos.data.School
import com.example.kivotos.data.local.LocalSchoolDataProvider

@Composable
fun SchoolListItem(
    school: School,
    onCardClick: (School) -> Unit,
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp)
) {
    Card(
        modifier = modifier,
        onClick = { onCardClick(school) },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        ),

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(128.dp)
            ) {
                Image(
                    painter = painterResource(school.imageId),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(128.dp)
                )

                Column {
                    Text(
                        text = stringResource(school.schoolName),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Placeholder",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }


        }
    }
}

@Composable
fun SchoolList(
    schools: List<School>,
    onClick: (School) -> Unit,
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp)
) {
    Scaffold(
        topBar = { SchoolTopAppBar() }
    ) { innerpadding ->
        LazyColumn(
            contentPadding = contentPaddingValues,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .padding(innerpadding)
        ) {
            items(schools, key = { school -> school.id }) { school ->
                SchoolListItem(
                    school = school,
                    onCardClick = onClick
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolTopAppBar(){
    CenterAlignedTopAppBar(title = { Text(text = "Blue Archive") })
}


@Preview
@Composable
fun SchoolPreview() {
    SchoolList(schools = LocalSchoolDataProvider.getSchoolData(), onClick = {})
}
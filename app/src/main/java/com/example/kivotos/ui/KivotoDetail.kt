package com.example.kivotos.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(
    uiState: KivotosUiState,
    onBackPressed: () -> Unit,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            DetailAppBar(onBackPressed = onBackPressed)
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(uiState.currentStudent.avatar),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = uiState.currentStudent.name),
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(30.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Hobbies:", style = MaterialTheme.typography.displaySmall)
            Text(
                text = stringResource(id = uiState.currentStudent.hobbies),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailAppBar(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Student Details") }, navigationIcon = {
            IconButton(
                onClick = onBackPressed
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
        }
    )

}


@Composable
fun DetailPreview() {
    val uiState: KivotosUiState
}
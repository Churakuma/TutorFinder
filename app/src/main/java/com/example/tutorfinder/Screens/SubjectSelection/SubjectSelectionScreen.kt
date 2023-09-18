package com.example.tutorfinder.Screens.SubjectSelection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorfinder.Data.DataSource
import com.example.tutorfinder.R

/**
 * Composable that allows the user to select their interests and what they are looking to study.
 */

@Composable
fun SubjectSelectionScreen(
    modifier: Modifier = Modifier,
    subjectList: List<Int>
) {
    val selectedSubjects = remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.subject_selection_prompt),
            color = colorResource(id = R.color.body_text)
        )
    }
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
    Column(
        modifier = modifier
            .padding(top = dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        subjectList.forEach { subjectName ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedSubjects.value,
                    onCheckedChange = { selectedSubjects.value = it }
                )
                Text(
                    text = stringResource(id = subjectName),
                    color = colorResource(id = R.color.body_text)
                )
            }
        }
        Button(
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.secondary),
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(text = stringResource(R.string.button_submit))
        }
    }
}


@Preview()
@Composable
fun SubjectSelectionScreenPreview() {
    SubjectSelectionScreen(
        subjectList = DataSource.subjectList
    )
}
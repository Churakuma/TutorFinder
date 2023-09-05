package com.example.tutorfinder.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorfinder.R

/**
 * Composable with a single button to send verification email to user input email. Should have back
 * press available in case user's email is incorrect.
 */

@Composable
fun VerificationScreen(
    modifier: Modifier = Modifier,
    emailInput: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.verification_text),
            color = colorResource(id = R.color.body_text)
        )
        Row(
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(R.string.verification_email_lead) +" ",
                color = colorResource(id = R.color.body_text)
            )
            Text(text = emailInput,
                color = colorResource(id = R.color.body_text))
        }
        Button(
            modifier = Modifier
                .padding(bottom = dimensionResource(id = R.dimen.padding_small),
                    top = dimensionResource(id = R.dimen.padding_medium)),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.secondary),
            ),
            onClick = { /*TODO: Send verification email using Firebase*/ }
        ) {
            Text(text = stringResource(R.string.button_verification_email))
        }
    }
}

@Preview
@Composable
fun VerificationScreenPreview() {
    VerificationScreen(emailInput = "zubair99ss@hotmail.com")
}
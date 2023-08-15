package com.example.tutorfinder.Screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorfinder.R

/**
 * Composable that allows the user to either login to the application or begin the process to sign
 * up for the service. Expects login credentials input as well as account type or [onSignUpClicked]
 * before triggering the navigations next screen
 */

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSelectionChanged: (String) -> Unit = {},
    options: List<String>
) {
    var selectedValue by rememberSaveable { mutableStateOf(" ") }
    var emailInput by remember { mutableStateOf(" ") }
    var passwordInput by remember { mutableStateOf(" ") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
            Image(
                painter = painterResource(id = R.drawable.tutorly___1_),
                contentDescription = stringResource(id = R.string.logo_desc),
                modifier = Modifier
                    .width(150.dp)
                    .height(135.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
            Text(
                text = stringResource(id = R.string.login_account_type_query),
                color = colorResource(id = R.color.body_text)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        }
        //TODO: CENTER THE RADIO BUTTONS RELATIVE TO THE IMAGE
        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            options.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(
                        color = colorResource(id = R.color.body_text),
                        text = item
                    )
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            EditTextField(
                label = R.string.login_email,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                value = emailInput,
                onValueChange = { emailInput = it },
                modifier = Modifier
                    .padding(bottom = dimensionResource(id = R.dimen.padding_small))
            )
            EditTextField(
                label = R.string.login_password,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                value = passwordInput,
                onValueChange = { passwordInput = it },
                modifier = Modifier
                    .padding(bottom = dimensionResource(id = R.dimen.padding_small))
            )
        }
        Spacer(modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.secondary),
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(text = stringResource(id = R.string.button_sign_in))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier) {

    OutlinedTextField(
        value = value,
        keyboardOptions = keyboardOptions,
        onValueChange = onValueChange,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = colorResource(id = R.color.background),
            focusedBorderColor = colorResource(id = R.color.accent),
            unfocusedBorderColor = colorResource(id = R.color.secondary)
        ),
        modifier = modifier
    )
}

fun onNextButtonClicked() {
    //TODO: Develop logic to login with Firebase/AWS
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(
        options = listOf("Tutor", "Student")
    )
}
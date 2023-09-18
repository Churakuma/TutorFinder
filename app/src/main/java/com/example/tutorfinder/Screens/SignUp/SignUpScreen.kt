package com.example.tutorfinder.Screens.SignUp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorfinder.R
import com.example.tutorfinder.Screens.Login.EditTextField

/**
 * Composable that requests user input of various data to create a profile and account witht the
 * application. Expects [firstName], [lastName], [email], [address] and a repeated [password] for
 * data verification
 */

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSelectionChanged: (String) -> Unit = {},
    options: List<String>
) {
    var selectedValue by rememberSaveable { mutableStateOf(" ") }
    var firstNameInput by rememberSaveable { mutableStateOf(" ") }
    var lastNameInput by rememberSaveable { mutableStateOf(" ") }
    var emailInput by rememberSaveable { mutableStateOf(" ") }
    var addressInput by rememberSaveable { mutableStateOf(" ") }
    var passwordInput by rememberSaveable { mutableStateOf(" ") }
    var secondPasswordInput by rememberSaveable { mutableStateOf(" ") }

     Column(
         modifier = modifier,
         verticalArrangement = Arrangement.SpaceBetween
     ) {
         Column(
             modifier = Modifier
                 .fillMaxWidth(),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {
             Text(
                 modifier = Modifier
                     .padding(top = dimensionResource(id = R.dimen.padding_medium)),
                 text = stringResource(R.string.signup_account_type),
                 color = colorResource(id = R.color.body_text)
             )
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
             EditTextField(
                 label = R.string.first_name,
                 keyboardOptions = KeyboardOptions.Default.copy(
                     keyboardType = KeyboardType.Text,
                     imeAction = ImeAction.Done
                 ),
                 value = firstNameInput,
                 onValueChange = { firstNameInput = it },
                 modifier = Modifier
                     .padding(bottom = dimensionResource(id = R.dimen.padding_small))
             )
             EditTextField(
                 label = R.string.last_name,
                 keyboardOptions = KeyboardOptions.Default.copy(
                     keyboardType = KeyboardType.Text,
                     imeAction = ImeAction.Done
                 ),
                 value = lastNameInput,
                 onValueChange = { lastNameInput = it },
                 modifier = Modifier
                     .padding(bottom = dimensionResource(id = R.dimen.padding_small))
             )
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
                 label = R.string.signup_address,
                 keyboardOptions = KeyboardOptions.Default.copy(
                     keyboardType = KeyboardType.Text,
                     imeAction = ImeAction.Done
                 ),
                 value = addressInput,
                 onValueChange = { addressInput = it },
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
             EditTextField(
                 label = R.string.login_password,
                 keyboardOptions = KeyboardOptions.Default.copy(
                     keyboardType = KeyboardType.Password,
                     imeAction = ImeAction.Done
                 ),
                 value = secondPasswordInput,
                 onValueChange = { secondPasswordInput = it },
                 modifier = Modifier
                     .padding(bottom = dimensionResource(id = R.dimen.padding_small))
             )
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
    }

/**
 * Function that validates the two password inputs from user match exactly
 */
fun validatePassword(context: Context, passwordInput: String, secondPasswordInput: String) {
    val text = context.getString(R.string.signup_password_mismatch)
    val duration = Toast.LENGTH_SHORT

    if (passwordInput != secondPasswordInput)
        Toast.makeText(context,text, duration).show()
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        options = listOf("Tutor","Student")
    )
}
package com.example.besonapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues

@Composable
fun LogInContent(
    buttonText: String,
    onButtonClick:() -> Unit,
){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val paddingValues = rememberInsetsPaddingValues(LocalWindowInsets.current.ime)
    val bottomPadding = paddingValues.calculateBottomPadding()

    println(bottomPadding)

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 150.dp),
        contentAlignment = Alignment.BottomCenter) {

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextField(
                entry = email,
                hint = "email",
                keyboardType = KeyboardType.Email){
                email = it
            }

            CustomTextField(
                entry = password,
                hint = "password",
                keyboardType = KeyboardType.Password){
                password = it
            }
            
            Button(onClick = { onButtonClick() }) {
                Text(text = buttonText)
            }
        }
    }
}
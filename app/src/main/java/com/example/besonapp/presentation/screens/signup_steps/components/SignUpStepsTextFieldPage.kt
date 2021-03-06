package com.example.besonapp.presentation.screens.signup_steps_as_customer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.besonapp.presentation.common_components.CustomButton
import com.example.besonapp.presentation.ui.theme.LOWER_VISIBILITY_ALPHA
import com.example.besonapp.presentation.ui.theme.textFieldBackgroundColor
import com.example.besonapp.presentation.ui.theme.onPrimaryColorNoTheme

@Composable
fun SignUpStepsTextFieldPage(
    modifier: Modifier = Modifier,
    entry: String,
    title: String,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onClick:(String) -> Unit
){
    var name by remember { mutableStateOf(entry) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.onBackground.copy(LOWER_VISIBILITY_ALPHA),
            style = MaterialTheme.typography.body1
        )
        SignUpStepsCustomTextField(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            entry = name,
            hint = hint,
            keyboardType = keyboardType,
            onChange = {
                name = it
            },
        )
        CustomButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
                onClick(name)
            }
        ) {
            Text(text = "??leri")
        }
    }
}

@Composable
fun SignUpStepsCustomTextField(
    modifier: Modifier,
    entry: String,
    hint: String,
    onChange:(String) -> Unit = {},
    maxLine: Int = 1,
    maxChar: Int = 20,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    var text by remember{ mutableStateOf("") }
    text = entry

    BasicTextField(
        modifier = modifier
            .background(
                textFieldBackgroundColor,
                RoundedCornerShape(percent = 50)
            )
            .padding(4.dp)
            .size(250.dp, 46.dp),
        value = text,
        onValueChange = {
            if(it.length <= maxChar){
                text = it
                onChange(it)
            }
        },
        singleLine = true,
        maxLines = maxLine,
        cursorBrush = SolidColor(onPrimaryColorNoTheme),
        textStyle = MaterialTheme.typography.h2.copy(
            color = onPrimaryColorNoTheme
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        decorationBox = { innerTextField ->
            Row(
                Modifier.padding(10.dp,0.dp,0.dp,0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart) {

                    if (text.isEmpty())
                        Text(hint,
                            style = LocalTextStyle.current.copy(
                                color = onPrimaryColorNoTheme.copy(alpha = 0.3f),
                                fontSize = 12.sp
                            )
                        )
                    innerTextField()
                }
            }
        }
    )
}
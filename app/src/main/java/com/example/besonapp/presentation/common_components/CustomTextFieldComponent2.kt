package com.example.besonapp.presentation.common_components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.theme.onPrimaryColorNoTheme

@Composable
fun CustomTextFieldComponent2(
    modifier: Modifier = Modifier,
    input: String,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange:(String) -> Unit
){

    var text by remember { mutableStateOf(input)}

    Surface(
        modifier = modifier
            .height(32.dp),
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colors.surface) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = text,
                textStyle = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
                onValueChange = {
                    text = it
                    onValueChange(it)
                },
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction =  ImeAction.Next),
                cursorBrush = SolidColor(MaterialTheme.colors.onPrimary),
                decorationBox = { innerTextField ->
                    if (text.isEmpty())
                        Text(
                            text = hint,
                            style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f))
                        )
                    innerTextField()
                }
            )
        }
    }
}
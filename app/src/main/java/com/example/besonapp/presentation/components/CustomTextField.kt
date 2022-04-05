package com.example.besonapp.presentation.components

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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.imePadding
import com.google.accompanist.insets.rememberInsetsPaddingValues

@Composable
fun CustomTextField(
    entry: String,
    hint: String,
    fontSize: TextUnit = 10.sp,
    maxLine: Int = 1,
    maxChar: Int = 50,
    keyboardType: KeyboardType = KeyboardType.Text,
    onFocusChange:(Boolean) -> Unit = {},
    onChange:(String) -> Unit = {}
) {

    var isNameChange by remember { mutableStateOf(false) }
    var isFocusChange by remember { mutableStateOf(false) }

    var text by remember{ mutableStateOf("") }
    text = entry

    BasicTextField(
        modifier = Modifier
            .background(
                MaterialTheme.colors.surface,
                RoundedCornerShape(percent = 50)
            )
            .padding(6.dp)
            .width(250.dp)
            .height(30.dp)
            .onFocusChanged {
                if (isNameChange) {
                    isFocusChange = true
                    onFocusChange(isFocusChange)
                }
            },
        value = text,
        onValueChange = {
            if(it.length <= maxChar){
                text = it
                onChange(it)
                isNameChange = true
            }
        },
        singleLine = true,
        maxLines = maxLine,
        cursorBrush = SolidColor(MaterialTheme.colors.onSurface),
        textStyle = LocalTextStyle.current.copy(
            fontSize = fontSize
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        decorationBox = { innerTextField ->
            Row(
                Modifier.padding(10.dp,0.dp,0.dp,0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(Modifier.weight(1f)) {
                    if (text.isEmpty())
                        Text(hint,
                            style = LocalTextStyle.current.copy(
                                color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f),
                                fontSize = fontSize
                            )
                        )
                    innerTextField()
                }
            }
        }
    )
}
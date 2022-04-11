package com.example.besonapp.presentation.common_components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.besonapp.R
import com.example.besonapp.ui.theme.backgroundLight
import com.example.besonapp.ui.theme.buttonAndTextFieldBackgroundColor
import com.example.besonapp.ui.theme.textFieldErrorColor

@Composable
fun CustomTextFieldComponent(
    entry: String,
    hint: String,
    textFieldError : Boolean = false,
    textFieldErrorMessage: String = "",
    fontSize: TextUnit = 14.sp,
    maxLine: Int = 1,
    maxChar: Int = 50,
    keyboardType: KeyboardType,
    onFocusChange:(Boolean) -> Unit = {},
    onChange:(String) -> Unit = {}
) {

    val localFocusManager = LocalFocusManager.current

    var isNameChange by remember { mutableStateOf(false) }
    var isFocusChange by remember { mutableStateOf(false) }

    var text by remember{ mutableStateOf("") }
    text = entry

    var passwordVisibility by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            modifier = Modifier
                .background(buttonAndTextFieldBackgroundColor)
                .border(1.dp, MaterialTheme.colors.onBackground)
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
            cursorBrush = SolidColor(MaterialTheme.colors.onPrimary),
            textStyle = LocalTextStyle.current.copy(
                fontSize = fontSize,
                color = MaterialTheme.colors.onPrimary
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction =  ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { localFocusManager.moveFocus(FocusDirection.Down)}),
            decorationBox = { innerTextField ->
                Row(
                    Modifier.padding(10.dp,0.dp,10.dp,0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(Modifier.weight(1f)) {
                        if (text.isEmpty())
                            Text(hint,
                                style = LocalTextStyle.current.copy(
                                    color = MaterialTheme.colors.onPrimary.copy(alpha = 0.3f),
                                    fontSize = fontSize
                                )
                            )
                        innerTextField()
                    }

                    if(keyboardType == KeyboardType.Password){
                        val image = if (passwordVisibility)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        val interactionSource = remember { MutableInteractionSource() }
                        IconButton(
                            modifier = Modifier.size(20.dp),
                            onClick = {
                                passwordVisibility = !passwordVisibility
                            },interactionSource = interactionSource, ) {
                            Icon(
                                imageVector = image,
                                contentDescription = null,
                                tint = MaterialTheme.colors.onPrimary)
                        }
                    }
                }
            },
            visualTransformation = if(keyboardType == KeyboardType.Password) if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation() else VisualTransformation.None,
        )

        if(textFieldError){
            Row(
                modifier = Modifier
                    .padding(start = 330.dp)
                    .size(60.dp, 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)) {

                Icon(
                    modifier = Modifier.size(12.dp),
                    imageVector = Icons.Default.ErrorOutline,
                    tint = textFieldErrorColor,
                    contentDescription = null)
                Text(
                    modifier = Modifier.weight(2f),
                    text = textFieldErrorMessage,
                    style = MaterialTheme.typography.caption,
                    color = textFieldErrorColor)
            }

        }
    }
}

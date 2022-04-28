package com.myapp.ui.feature.components

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class AddSymbolIntoTextFieldVisualTransformation(addedSymbol: String) : VisualTransformation {

    private val addedSymbol = addedSymbol

    override fun filter(text: AnnotatedString): TransformedText {
        if(text.isNotEmpty()){
            return TransformedText(
                AnnotatedString("$text $addedSymbol"),
                OffsetMapping.Identity
            )
        }else{
            return TransformedText(
                AnnotatedString(text.toString()),
                OffsetMapping.Identity
            )
        }
    }
}

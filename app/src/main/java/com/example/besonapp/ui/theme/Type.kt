package com.example.besonapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.besonapp.R

// Set of Material typography styles to start with+

val Roboto = FontFamily(
    Font(R.font.roboto_black),
    Font(R.font.roboto_blackitalic, weight = FontWeight.Black, style = FontStyle.Italic),
    Font(R.font.roboto_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.roboto_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.roboto_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.roboto_light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(R.font.roboto_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.roboto_medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(R.font.roboto_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.roboto_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(R.font.roboto_thin, weight = FontWeight.Thin, style = FontStyle.Normal),
    Font(R.font.roboto_thin_italic, weight = FontWeight.Thin, style = FontStyle.Italic),
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp
    ),
    h2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    h3 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    h4 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h5 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    ),
    caption = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 8.sp,
    ),
    button = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp
    )
)

const val LOWER_VISIBILITY_ALPHA = 0.8f
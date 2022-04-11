package com.example.besonapp.presentation.model

import com.example.besonapp.R

data class IntroScreenElement(
    val imageResource: Int,
    val explanationText: String,
    val textPadding: Float
) {
    companion object{

        var staticIntroElementList = listOf<IntroScreenElement>()

        val introElement1 =
            IntroScreenElement(
                imageResource = R.drawable.screenshot_1,
                explanationText = "BEŞON, İNŞAAT YAPIM FİYATLARI TAKİP VE TAŞERON BULMA PLATFORMUDUR.",
                textPadding = 580f
            )

        val introElement2 =
            IntroScreenElement(
                imageResource = R.drawable.screenshot_2,
                explanationText = "İSTER MÜŞTERİ OLARAK GÜNCEL İNŞAAT FİYATLARINI TAKİP ET VE İŞİNİ YAPTIRACAK FİRMA BUL",
                textPadding = 580f)

        val introElement3 =
            IntroScreenElement(
                imageResource = R.drawable.screenshot_3,
                explanationText = "İSTER FİRMA OLARAK FİYATLARIN GÜNCEL KALMASINA DESTEK VER VE MÜŞTERİ BUL.",
                textPadding = 580f)

        val introElement4 =
            IntroScreenElement(
                imageResource = R.drawable.screenshot_4,
                explanationText = "HEMDE BEDAVA",
                textPadding = 340f)

        fun createListOfIntroElement(){
            staticIntroElementList = staticIntroElementList + introElement1
            staticIntroElementList = staticIntroElementList + introElement2
            staticIntroElementList = staticIntroElementList + introElement3
            staticIntroElementList = staticIntroElementList + introElement4
        }

        init {
            createListOfIntroElement()
        }
    }
}
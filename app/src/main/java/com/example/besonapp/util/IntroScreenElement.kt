package com.example.besonapp.util

import com.example.besonapp.R

data class IntroScreenElement(
    val imageResource: Int,
    val explanationText: String,
    val textPadding: Float
) {
    companion object{

        //Create static data for intro screen elements.

        var staticIntroElementList = listOf<IntroScreenElement>()

        val introElement1 =
            IntroScreenElement(
                imageResource = R.drawable.besonapp_ss_splash,
                explanationText = "BEŞON, BİNA YAPIM FİYATLARI TAKİP VE TAŞERON BULMA PLATFORMUDUR.",
                textPadding = 580f
            )

        val introElement2 =
            IntroScreenElement(
                imageResource = R.drawable.besonapp_ss_signup_customer,
                explanationText = "İSTER MÜŞTERİ OLARAK GÜNCEL İNŞAAT FİYATLARINI TAKİP ET VE İŞİNİ YAPTIRACAK FİRMA BUL",
                textPadding = 580f)

        val introElement3 =
            IntroScreenElement(
                imageResource = R.drawable.besonapp_ss_signup_company,
                explanationText = "İSTER FİRMA OLARAK FİYATLARIN GÜNCEL KALMASINA DESTEK VER VE MÜŞTERİ BUL.",
                textPadding = 580f)

        val introElement4 =
            IntroScreenElement(
                imageResource = R.drawable.besonapp_ss_signup,
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
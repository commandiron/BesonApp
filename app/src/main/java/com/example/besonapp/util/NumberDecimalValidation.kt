package com.example.besonapp.util

object NumberDecimalValidation {
    fun getValidatedNumber(text: String): String {
        var filteredChars = text.replace(",", "").replace(".", "")

        when(filteredChars.length){
            4,5,6-> {
                filteredChars = StringBuilder(filteredChars).insert(filteredChars.length -3, ".").toString()
            }
            7,8,9-> {
                filteredChars = text.replace(",", "").replace(".", "")
                filteredChars = StringBuilder(filteredChars).insert(filteredChars.length -3, ".").insert(filteredChars.length -6, ".").toString()
            }
        }
        return (filteredChars)
    }
}
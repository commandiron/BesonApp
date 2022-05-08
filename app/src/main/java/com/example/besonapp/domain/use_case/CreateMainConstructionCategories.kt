package com.example.besonapp.domain.use_case

import com.example.besonapp.presentation.model.MainConstructionItem

class CreateMainConstructionCategories  {
    fun invoke(): List<MainConstructionItem> {
        return MainConstructionItem.createMainCategories()
    }
}
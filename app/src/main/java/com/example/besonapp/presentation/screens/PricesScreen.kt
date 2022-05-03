package com.example.besonapp.presentation.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.common_components.CustomTextFieldComponent2
import com.example.besonapp.presentation.model.ConstructionPriceItem
import com.example.besonapp.presentation.model.MainConstructionItem
import com.example.besonapp.presentation.model.SubConstructionItem
import com.example.besonapp.presentation.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.theme.primaryColorNoTheme

@Composable
fun PricesScreen(navController: NavController){

    var filterCheckBoxEnable by remember { mutableStateOf(false)}

    var searchBoxText by remember { mutableStateOf("")}

    //Bu kısım viewmodelden kullanıcı profili olarak gelecek.
    val mainConstructionItems = MainConstructionItem.createMainCategories()

    var selectedMainConstructionItem by remember { mutableStateOf<MainConstructionItem?>(null) }

    var subConstructionItems by remember { mutableStateOf<List<SubConstructionItem>?>(null) }

    LaunchedEffect(key1 = selectedMainConstructionItem){
        if(selectedMainConstructionItem != null){
            subConstructionItems = selectedMainConstructionItem?.subConstructionCategories
        }
    }

    var selectedSubConstructionItem by remember { mutableStateOf<SubConstructionItem?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)) {

        Row(modifier = Modifier
            .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CustomTextFieldComponent2(
                modifier = Modifier.weight(3f),
                input = searchBoxText,
                hint = "Ara",
                onValueChange = {searchBoxText = it}
            )

            val interactionSource = remember { MutableInteractionSource() }
            
            Row(
                modifier = Modifier
                    .weight(1f).clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = {filterCheckBoxEnable = !filterCheckBoxEnable}),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {

                var iconVector by remember { mutableStateOf(Icons.Default.KeyboardArrowRight)}

                iconVector = if(filterCheckBoxEnable){
                    Icons.Default.KeyboardArrowDown
                }else{
                    Icons.Default.KeyboardArrowRight
                }

                Text(
                    text = "Filitrele",
                    textAlign = TextAlign.Center)
                Icon(
                    imageVector = iconVector, contentDescription = null)
            }
        }


        if(filterCheckBoxEnable){

            Text(text = "Ana İnşaat Kategorisi Filtre")

            LazyRow(
            ){
                items(mainConstructionItems){ item ->

                    var mainCategorySelected by remember { mutableStateOf(false) }

                    mainCategorySelected = item == selectedMainConstructionItem

                    var mainCategorySurfaceSelectedColor by remember { mutableStateOf(primaryColorNoTheme) }
                    var mainCategorySurfaceContentColor by remember { mutableStateOf(onPrimaryColorNoTheme) }

                    if(mainCategorySelected){
                        mainCategorySurfaceSelectedColor = onPrimaryColorNoTheme
                        mainCategorySurfaceContentColor = primaryColorNoTheme
                    }else{
                        mainCategorySurfaceSelectedColor = primaryColorNoTheme
                        mainCategorySurfaceContentColor = onPrimaryColorNoTheme
                    }

                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(96.dp, 36.dp),
                        color = mainCategorySurfaceSelectedColor,
                        contentColor = mainCategorySurfaceContentColor,
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    selectedMainConstructionItem = item
                                    mainCategorySelected = !mainCategorySelected
                                },
                            contentAlignment = Alignment.Center) {
                            Text(
                                text = item.title,
                                textAlign = TextAlign.Center)
                        }
                    }


                }
            }
        }

        if(filterCheckBoxEnable && subConstructionItems != null){
            Text(text = "Alt İnşaat Kategorisi Filtre")

            LazyRow(
            ){

                items(subConstructionItems!!){ item ->

                    var mainCategorySelected by remember { mutableStateOf(false) }

                    mainCategorySelected = item == selectedSubConstructionItem

                    var mainCategorySurfaceSelectedColor by remember { mutableStateOf(primaryColorNoTheme) }
                    var mainCategorySurfaceContentColor by remember { mutableStateOf(onPrimaryColorNoTheme) }

                    if(mainCategorySelected){
                        mainCategorySurfaceSelectedColor = onPrimaryColorNoTheme
                        mainCategorySurfaceContentColor = primaryColorNoTheme
                    }else{
                        mainCategorySurfaceSelectedColor = primaryColorNoTheme
                        mainCategorySurfaceContentColor = onPrimaryColorNoTheme
                    }

                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(96.dp, 36.dp),
                        color = mainCategorySurfaceSelectedColor,
                        contentColor = mainCategorySurfaceContentColor,
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    selectedSubConstructionItem = item
                                    mainCategorySelected = !mainCategorySelected
                                },
                            contentAlignment = Alignment.Center) {
                            Text(
                                text = item.title,
                                textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }

        LazyColumn(modifier = Modifier
            .fillMaxSize()){

            items(
                listOf(
                    ConstructionPriceItem(title = "Sinterflex Cephe Kaplaması", unit = "m²", price = 500.0),
                    ConstructionPriceItem(title = "Kompozit Cephe Kaplaması", unit = "m²", price = 500.0),
                    ConstructionPriceItem(title = "Klozet", unit = "ad", price = 1200.0),
                    ConstructionPriceItem(title = "Lavabo", unit = "ad", price = 630.0),
                    ConstructionPriceItem(title = "Batarya", unit = "ad", price = 1950.0))){ item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    shape = RoundedCornerShape(10.dp)) {

                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)) {
                        Text(text = item.title)
                        Text(text = item.price.toString())
                    }
                }
            }
        }
    }
}
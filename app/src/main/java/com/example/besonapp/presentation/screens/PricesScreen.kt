package com.example.besonapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.besonapp.R
import com.example.besonapp.presentation.common_components.CustomTextFieldComponent2
import com.example.besonapp.presentation.model.ConstructionPriceItem
import com.example.besonapp.presentation.common_components.CustomCircleCheckbox
import com.example.besonapp.presentation.model.MainConstructionItem
import com.example.besonapp.presentation.model.SubConstructionItem
import com.example.besonapp.presentation.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.theme.primaryColorNoTheme
import java.text.SimpleDateFormat
import java.util.*

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

    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = 64.dp, bottom = 86.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)) {

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
            
            Row(
                modifier = Modifier
                    .weight(1f)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = { filterCheckBoxEnable = !filterCheckBoxEnable }),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {

                var iconVector by remember { mutableStateOf(Icons.Default.KeyboardArrowRight)}

                iconVector = if(filterCheckBoxEnable){
                    Icons.Default.KeyboardArrowDown
                }else{
                    Icons.Default.KeyboardArrowRight
                }

                Text(
                    text = if(filterCheckBoxEnable) "Kapat" else "Filitrele",
                    textAlign = TextAlign.Center)
                Icon(
                    imageVector = iconVector, contentDescription = null)
            }
        }


        if(filterCheckBoxEnable){

            LazyRow(
            ){
                items(mainConstructionItems){ item ->

                    var mainCategorySelected by remember { mutableStateOf(false) }

                    mainCategorySelected = item == selectedMainConstructionItem

                    var mainCategorySurfaceSelectedColor by remember { mutableStateOf(primaryColorNoTheme) }
                    var mainCategorySurfaceContentColor by remember { mutableStateOf(onPrimaryColorNoTheme) }

                    if(mainCategorySelected){
                        mainCategorySurfaceSelectedColor = primaryColorNoTheme
                        mainCategorySurfaceContentColor = onPrimaryColorNoTheme
                    }else{
                        mainCategorySurfaceSelectedColor = primaryColorNoTheme
                        mainCategorySurfaceContentColor = onPrimaryColorNoTheme
                    }

                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .wrapContentWidth()
                            .height(36.dp)
                            .defaultMinSize(minWidth = 64.dp),
                        color = mainCategorySurfaceSelectedColor,
                        contentColor = mainCategorySurfaceContentColor,
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) {
                                    selectedMainConstructionItem = item
                                    mainCategorySelected = !mainCategorySelected
                                },
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .padding(4.dp),
                                contentAlignment = Alignment.Center
                            ){
                                CustomCircleCheckbox(
                                    selected = mainCategorySelected,
                                    unSelectedBackground = primaryColorNoTheme,
                                    unselectedTint = onPrimaryColorNoTheme,
                                    selectedTint = primaryColorNoTheme,
                                    selectedBackground = onPrimaryColorNoTheme)
                            }
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.Center)
                        }
                    }


                }
            }
        }

        if(filterCheckBoxEnable && subConstructionItems != null){

            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp), thickness = 1.dp, color = MaterialTheme.colors.onPrimary)

            LazyRow(
            ){

                items(subConstructionItems!!){ item ->

                    var subCategorySelected by remember { mutableStateOf(false) }

                    subCategorySelected = item == selectedSubConstructionItem

                    var subCategorySurfaceSelectedColor by remember { mutableStateOf(primaryColorNoTheme) }
                    var subCategorySurfaceContentColor by remember { mutableStateOf(onPrimaryColorNoTheme) }

                    if(subCategorySelected){
                        subCategorySurfaceSelectedColor = primaryColorNoTheme
                        subCategorySurfaceContentColor = onPrimaryColorNoTheme
                    }else{
                        subCategorySurfaceSelectedColor = primaryColorNoTheme
                        subCategorySurfaceContentColor =  onPrimaryColorNoTheme
                    }

                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .wrapContentWidth()
                            .height(36.dp)
                            .defaultMinSize(minWidth = 64.dp),
                        color = subCategorySurfaceSelectedColor,
                        contentColor = subCategorySurfaceContentColor,
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) {
                                    selectedSubConstructionItem = item
                                },
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .padding(4.dp),
                                contentAlignment = Alignment.Center
                            ){
                                CustomCircleCheckbox(
                                    selected = subCategorySelected,
                                    unSelectedBackground = primaryColorNoTheme,
                                    unselectedTint = onPrimaryColorNoTheme,
                                    selectedTint = primaryColorNoTheme,
                                    selectedBackground = onPrimaryColorNoTheme)
                            }
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }

        val sdf = remember { SimpleDateFormat( "dd/MM/yyyy", Locale.ROOT) }

        LazyColumn(
            modifier = Modifier
            .fillMaxSize()){

            items(
                listOf(
                    ConstructionPriceItem(title = "Sinterflex Cephe Kaplaması", unit = "m²", price = 500.0, date = System.currentTimeMillis()),
                    ConstructionPriceItem(title = "Kompozit Cephe Kaplaması", unit = "m²", price = 500.0, date = System.currentTimeMillis()),
                    ConstructionPriceItem(title = "Klozet", unit = "ad", price = 1200.0, date = System.currentTimeMillis()),
                    ConstructionPriceItem(title = "Lavabo", unit = "ad", price = 630000.0, date = System.currentTimeMillis()),
                    ConstructionPriceItem(title = "Lavabo", unit = "ad", price = 680.0, date = System.currentTimeMillis()),
                    ConstructionPriceItem(title = "Lavabo", unit = "ad", price = 730.0, date = System.currentTimeMillis()),
                    ConstructionPriceItem(title = "Lavabo", unit = "ad", price = 730.0, date = System.currentTimeMillis()),
                    ConstructionPriceItem(title = "Lavabo", unit = "ad", price = 730.0, date = System.currentTimeMillis()),
                    ConstructionPriceItem(title = "Batarya", unit = "ad", price = 1950.0, date = System.currentTimeMillis())
                )){ item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    shape = RoundedCornerShape(30.dp)) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp),
                        verticalArrangement = Arrangement.Center) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier
                                .weight(1f)) {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.h4
                                )
                                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    Text(text = item.location)
                                    Text(text = sdf.format(item.date))
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .weight(1f),
                                contentAlignment = Alignment.CenterEnd) {
                                Text(
                                    text = item.price.toString() + " TL/" + item.unit,
                                    style = MaterialTheme.typography.h3
                                )
                            }
                        }
                    }

                    var enableAlertDialog by remember { mutableStateOf(false) }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp, vertical = 10.dp),
                        contentAlignment = Alignment.BottomEnd) {

                        Row() {
                            Text(
                                text = "Gönderen: ",
                                style = MaterialTheme.typography.caption)
                            Text(
                                modifier = Modifier.clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ){

                                 enableAlertDialog = !enableAlertDialog

                                 //Burda alert dialog ile gönderenin profilini göster.

                                },
                                text = item.userByName,
                                style = MaterialTheme.typography.caption,
                                color = primaryColorNoTheme)
                        }
                    }

                    val mainConstructionItem = MainConstructionItem.createMainCategories()[4]

                    if(enableAlertDialog){
                        ProfileViewDialog(
                            //Bu kısım viewmodelden gelecek.
                            firstContent = listOf(mainConstructionItem.title),
                            secondContent = mainConstructionItem.subConstructionCategories!!.map { it.title }
                        ){
                            enableAlertDialog = !enableAlertDialog
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileViewDialog(
    firstContent: List<String>,
    secondContent: List<String>,
    onDismissRequest:() -> Unit
){

    Dialog(
        onDismissRequest = {
            onDismissRequest()
        },
    ){
        Surface(
            modifier = Modifier
                .width(300.dp)) {
            Column(
                modifier = Modifier
                    .heightIn(max = 400.dp)
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Image(
                    painter = rememberImagePainter(data = R.drawable.ic_blank_profile_picture),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop)

                Text(
                    text = "Demirli İnşaat San. Tic. Ltd. Şti.",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onBackground)

                Text(
                    text = "Tel: 0535 508 55 52",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground)

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Ana Faaliyet Alanı:",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground)

                Divider(modifier = Modifier.padding(horizontal = 10.dp), color = MaterialTheme.colors.onPrimary, thickness = 1.dp)

                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(firstContent){ item ->
                        Text(
                            text = item,
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.onBackground)

                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Uzmanlık Alanları",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground)

                Divider(modifier = Modifier.padding(horizontal = 10.dp), color = MaterialTheme.colors.onPrimary, thickness = 1.dp)

                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(secondContent){ item ->
                        Text(
                            text = item,
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.onBackground)

                    }
                }
            }
            
        }
    }
}
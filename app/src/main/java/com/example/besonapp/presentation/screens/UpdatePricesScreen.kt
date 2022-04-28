package com.example.besonapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.besonapp.presentation.model.ConstructionItem
import com.example.besonapp.presentation.theme.insertPriceButtonColor
import com.example.besonapp.presentation.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.theme.primaryColorNoTheme
import com.example.besonapp.util.NumberDecimalValidation.getValidatedNumber
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.myapp.ui.feature.components.AddSymbolIntoTextFieldVisualTransformation

@Composable
fun UpdatePricesScreen(
    navController: NavController){

    var price by remember { mutableStateOf("")}

    //Bu kısım viewmodelden kullanıcı profili olarak gelecek.
    val data = ConstructionItem.createCategories()[6]
    //Bu kısım viewmodelden kullanıcı profili olarak gelecek.
    val items = data.subCategories ?: emptyList()

    var dropDownMenuIsExpanded by remember { mutableStateOf(false) }
    var dropDownMenuSelectedIndex by remember { mutableStateOf(0) }

    val keyboardController = LocalSoftwareKeyboardController.current
    var enableAlertDialog by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .imePadding() //*Klavyenin üstünde beyaz bir boşluk kalıyor.
            .heightIn(max = 414.dp),
        color = primaryColorNoTheme,
        contentColor = onPrimaryColorNoTheme
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            contentAlignment = Alignment.TopCenter) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Text(text = "Fiyat Kategorisini Seç")

                Surface(
                    modifier = Modifier
                        .clickable(
                            onClick = { dropDownMenuIsExpanded = true }),
                    color = onPrimaryColorNoTheme,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = items[dropDownMenuSelectedIndex].title,
                                textAlign = TextAlign.Center,
                                color = primaryColorNoTheme)
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                tint = primaryColorNoTheme,
                                contentDescription = null)
                        }
                    }
                    Box(modifier = Modifier
                            .offset(x = 0.dp, y = 40.dp)) {
                        DropdownMenu(
                            expanded = dropDownMenuIsExpanded,
                            onDismissRequest = { dropDownMenuIsExpanded = false },
                            modifier = Modifier
                                .requiredSizeIn(maxHeight = 160.dp, maxWidth = 128.dp)
                                .background(onPrimaryColorNoTheme)
                        ) {

                            items.forEachIndexed { index, s ->

                                Column(
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    DropdownMenuItem(onClick = {
                                        dropDownMenuSelectedIndex = index
                                        dropDownMenuIsExpanded = false
                                    }) {

                                        if(index == dropDownMenuSelectedIndex){
                                            Text(
                                                text = s.title,
                                                color = primaryColorNoTheme)
                                        }else{
                                            Text(
                                                text = s.title,
                                                color = Color.White)
                                        }
                                    }
                                    Divider(
                                        thickness = 1.dp,
                                        color = primaryColorNoTheme
                                    )
                                }
                            }
                        }
                    }
                }

                Text(text = "Fiyat Gir")

                Surface(
                    modifier = Modifier.size(224.dp, 64.dp),
                    color = onPrimaryColorNoTheme,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center) {

                        BasicTextField(
                            value = price,
                            onValueChange = {
                                if (it.length <= 11) price = getValidatedNumber(it)
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                autoCorrect = false),
                            singleLine = true,
                            textStyle = MaterialTheme.typography.h2.copy(color = primaryColorNoTheme),
                            cursorBrush = SolidColor(primaryColorNoTheme),
                            visualTransformation = AddSymbolIntoTextFieldVisualTransformation("TL / m²")
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(10.dp))
                
                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = onPrimaryColorNoTheme,
                        contentColor = insertPriceButtonColor
                    ),
                    onClick = {

                        //Burda alert dialog çalışacak

                        enableAlertDialog = !enableAlertDialog

                    }
                ){
                    
                    Text(text = "FİYATI GÖNDER")
                }
            }
        }
    }
    if(enableAlertDialog){
        AlertDialog(
            modifier = Modifier.size(300.dp,100.dp),
            onDismissRequest = {

                keyboardController?.hide()
                enableAlertDialog =! enableAlertDialog
            },
            buttons = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)) {
                    Button(
                        onClick = {
                            //Fiyatı gönder
                        }) {
                        Text(text = "Evet")
                    }
                    Button(
                        onClick = {
                            enableAlertDialog =! enableAlertDialog
                        }) {
                        Text(text = "Hayır")
                    }
                }
            },
            title = {
                Text(text = "Fiyat gönderilecek. Emin misiniz?")
            },
            shape = RoundedCornerShape(30.dp),
            backgroundColor = Color.White,
            contentColor = Color.Black,
            properties = DialogProperties()

        )
    }
}
















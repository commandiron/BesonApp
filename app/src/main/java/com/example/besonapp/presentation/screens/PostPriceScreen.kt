package com.example.besonapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.besonapp.presentation.model.ConstructionPriceItem
import com.example.besonapp.presentation.model.MainConstructionItem
import com.example.besonapp.presentation.ui.theme.insertPriceButtonColor
import com.example.besonapp.presentation.ui.theme.onPrimaryColorNoTheme
import com.example.besonapp.presentation.ui.theme.primaryColorNoTheme
import com.example.besonapp.util.ThousandSeparatorVisualTransformationWithAddedSymbol

@Composable
fun PostPriceScreen(
    navController: NavController) {

    var price by remember { mutableStateOf("") }

    //Bu kısım viewmodelden kullanıcı profili olarak gelecek.
    val mainConstructionItems = MainConstructionItem.createMainCategories()[6]
    //Bu kısım viewmodelden kullanıcı profili olarak gelecek.
    val subConstructionCategories = mainConstructionItems.subConstructionCategories ?: emptyList()
    //Bu kısım viewmodelden kullanıcı profili olarak gelecek.
    var priceCategories by remember { mutableStateOf<List<ConstructionPriceItem>>(listOf()) }

    var firstDropDownMenuIsExpanded by remember { mutableStateOf(false) }
    var firstDropDownMenuSelectedIndex by remember { mutableStateOf(0) }

    var secondDropDownMenuIsExpanded by remember { mutableStateOf(false) }
    var secondDropDownMenuSelectedIndex by remember { mutableStateOf(0) }

    val keyboardController = LocalSoftwareKeyboardController.current
    var enableAlertDialog by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            //.imePadding() //*Klavyenin üstünde beyaz bir boşluk kalıyor, başka ekran boyutlarında sıkıntı çıkarıyor.
            .heightIn(max = 414.dp),
        color = primaryColorNoTheme,
        contentColor = onPrimaryColorNoTheme
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Text(text = "Kategori Seç")

                val interactionSource = remember { MutableInteractionSource() }

                Surface(
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                secondDropDownMenuSelectedIndex = 0
                                firstDropDownMenuIsExpanded = true
                                secondDropDownMenuIsExpanded = false
                            }),
                    color = onPrimaryColorNoTheme,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = subConstructionCategories[firstDropDownMenuSelectedIndex].title,
                                textAlign = TextAlign.Center,
                                color = primaryColorNoTheme
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                tint = primaryColorNoTheme,
                                contentDescription = null
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .offset(x = 0.dp, y = 40.dp)
                    ) {
                        DropdownMenu(
                            expanded = firstDropDownMenuIsExpanded,
                            onDismissRequest = { firstDropDownMenuIsExpanded = false },
                            modifier = Modifier
                                .requiredSizeIn(maxHeight = 160.dp, maxWidth = 128.dp)
                                .background(onPrimaryColorNoTheme)
                        ) {

                            subConstructionCategories.forEachIndexed { index, s ->

                                Column(
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    DropdownMenuItem(onClick = {
                                        priceCategories =
                                            subConstructionCategories[index].priceCategories
                                                ?: emptyList()
                                        firstDropDownMenuSelectedIndex = index
                                        firstDropDownMenuIsExpanded = false
                                    }) {

                                        if (index == firstDropDownMenuSelectedIndex) {
                                            Text(
                                                text = s.title,
                                                color = primaryColorNoTheme
                                            )
                                        } else {
                                            Text(
                                                text = s.title,
                                                color = Color.White
                                            )
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

                Text(text = "Girilecek Fiyatı Seç")

                Surface(
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                firstDropDownMenuIsExpanded = false
                                secondDropDownMenuIsExpanded = true
                            }),
                    color = onPrimaryColorNoTheme,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .defaultMinSize(minWidth = 100.dp, minHeight = 46.dp)
                            .wrapContentSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (priceCategories != listOf<ConstructionPriceItem>()) {
                                Text(
                                    text = priceCategories[secondDropDownMenuSelectedIndex].title,
                                    textAlign = TextAlign.Center,
                                    color = primaryColorNoTheme
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    tint = primaryColorNoTheme,
                                    contentDescription = null
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .offset(x = 0.dp, y = 40.dp)
                    ) {
                        DropdownMenu(
                            expanded = secondDropDownMenuIsExpanded,
                            onDismissRequest = { secondDropDownMenuIsExpanded = false },
                            modifier = Modifier
                                .requiredSizeIn(maxHeight = 160.dp, maxWidth = 128.dp)
                                .background(onPrimaryColorNoTheme)
                        ) {

                            priceCategories.forEachIndexed { index, constructionPriceItem ->

                                Column(
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    DropdownMenuItem(onClick = {
                                        secondDropDownMenuSelectedIndex = index
                                        secondDropDownMenuIsExpanded = false
                                    }) {

                                        if (index == secondDropDownMenuSelectedIndex) {
                                            Text(
                                                text = constructionPriceItem.title,
                                                color = primaryColorNoTheme
                                            )
                                        } else {
                                            Text(
                                                text = constructionPriceItem.title,
                                                color = Color.White
                                            )
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
                        contentAlignment = Alignment.Center
                    ) {

                        if (priceCategories != listOf<ConstructionPriceItem>()) {
                            BasicTextField(
                                value = price,
                                onValueChange = {
                                    if (it.length <= 10) price = it
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    autoCorrect = false
                                ),
                                keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()}),
                                singleLine = true,
                                textStyle = MaterialTheme.typography.h2.copy(color = primaryColorNoTheme),
                                cursorBrush = SolidColor(primaryColorNoTheme),
                                visualTransformation =
                                ThousandSeparatorVisualTransformationWithAddedSymbol(
                                    maxFractionDigits = 2,
                                    addedSymbol = " TL/" + priceCategories[secondDropDownMenuSelectedIndex].unit)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = insertPriceButtonColor,
                        contentColor = onPrimaryColorNoTheme
                    ),
                    shape = RoundedCornerShape(10.dp),
                    onClick = {

                        //Burda alert dialog çalışacak

                        enableAlertDialog = !enableAlertDialog

                    }
                ) {

                    Text(text = "FİYATI GÖNDER")
                }
            }
        }
    }
    if (enableAlertDialog) {
        AlertDialog(
            modifier = Modifier.size(300.dp, 100.dp),
            onDismissRequest = {

                keyboardController?.hide()
                enableAlertDialog = !enableAlertDialog
            },
            buttons = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        10.dp,
                        Alignment.CenterHorizontally
                    )
                ) {
                    Button(
                        onClick = {
                            //Fiyatı gönder
                        }) {
                        Text(text = "Evet")
                    }
                    Button(
                        onClick = {
                            enableAlertDialog = !enableAlertDialog
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
















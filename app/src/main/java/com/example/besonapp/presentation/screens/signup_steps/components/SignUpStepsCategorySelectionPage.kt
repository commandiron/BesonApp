package com.example.besonapp.presentation.screens.signup_steps.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.model.ConstructionItem

@Composable
fun SignUpStepsCategorySelectionPage(
    itemList: List<ConstructionItem>,
    buttonText: String,
    onNextButtonClick:(Int) -> Unit
){

    var selectedItemId by remember { mutableStateOf(0)}

    Column(
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.height(20.dp),
            text = "Ana Katagori Seçiniz.",
            style = MaterialTheme.typography.body1
        )

        var iconSize by remember { mutableStateOf(50.dp)}
        var boxBorder by remember { mutableStateOf(1.dp)}

        LazyVerticalGrid(
            modifier = Modifier.size(300.dp),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
            columns = GridCells.Fixed(3),
            content = {

                items(itemList){ item ->

                    //NASIL SADECE TEK BİR GRİDİ SEÇEBİLİRİM BURADA KALDIM/////////////////////////

                    var isSelected by remember { mutableStateOf(false)}

                    if(isSelected){
                        iconSize = 70.dp
                        boxBorder = 2.dp
                    }else{
                        iconSize = 50.dp
                        boxBorder = 1.dp
                    }

                    Box(modifier = Modifier
                        .size(100.dp)
                        .padding(1.dp)
                        .border(boxBorder, MaterialTheme.colors.onBackground)
                        .clickable {
                            isSelected = !isSelected

                            selectedItemId = item.id
                        },
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            modifier = Modifier
                            .size(iconSize),
                            imageVector = item.icon,
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary)
                    }
                }
            }
        )

        Button(
            onClick = {

                onNextButtonClick(selectedItemId)

            }) {
            Text(text = buttonText)
        }
    }
}
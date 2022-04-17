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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.model.ConstructionItem

@Composable
fun SignUpStepsCategorySelectionPage(
    title: String,
    itemList: List<ConstructionItem>,
    buttonText: String,
    multipleSelectionEnabled: Boolean,
    onNextButtonClickSingleSelection: ((ConstructionItem?) -> Unit)? = null,
    onNextButtonClickMultipleSelection: ((List<ConstructionItem>?) -> Unit)? = null
){

    var selectedItemList by remember { mutableStateOf<List<ConstructionItem>?>(null) }
    var selectedItem by remember { mutableStateOf<ConstructionItem?>(null) }

    Column(
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.height(20.dp),
            text = title,
            style = MaterialTheme.typography.body1
        )

        var gridIconSize by remember { mutableStateOf(50.dp)}
        var gridBoxBorder by remember { mutableStateOf(1.dp)}

        LazyVerticalGrid(
            modifier = Modifier.size(300.dp),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
            columns = GridCells.Fixed(3),
            content = {

                items(itemList){ item ->

                    var isSelected by remember { mutableStateOf(false)}

                    if(!multipleSelectionEnabled){
                        isSelected = item == selectedItem
                    }

                    if(isSelected){
                        gridIconSize = 70.dp
                        gridBoxBorder = 2.dp
                    }else{
                        gridIconSize = 50.dp
                        gridBoxBorder = 1.dp
                    }

                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(1.dp)
                            .border(
                                gridBoxBorder,
                                MaterialTheme.colors.onBackground)
                            .clickable {
                                if(multipleSelectionEnabled){
                                    isSelected = !isSelected
                                    selectedItemList = listOf(item)
                                }else{
                                    selectedItem = item
                                }
                            },
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            modifier = Modifier
                                .size(gridIconSize),
                            imageVector = Icons.Default.Settings,
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary)
                    }
                }
            }
        )

        Button(
            onClick = {
                if(multipleSelectionEnabled){
                    onNextButtonClickMultipleSelection!!.invoke(selectedItemList)
                }else{
                    onNextButtonClickSingleSelection!!.invoke(selectedItem)
                }
            }) {
            Text(text = buttonText)
        }
    }
}
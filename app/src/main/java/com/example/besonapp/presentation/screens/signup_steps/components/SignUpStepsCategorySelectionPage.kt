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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.besonapp.presentation.common_components.CircleCheckbox
import com.example.besonapp.presentation.model.ConstructionItem

@Composable
fun SignUpStepsCategorySelectionPage(
    title: String,
    underButtonHintText: String = "",
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
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.height(20.dp),
            text = title,
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(20.dp))

        var gridIconSize by remember { mutableStateOf(80.dp)}
        var gridBoxBorder by remember { mutableStateOf(1.dp)}

        LazyVerticalGrid(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            columns = GridCells.Fixed(3),
            content = {

                items(itemList){ item ->

                    var isSelected by remember { mutableStateOf(false)}
                    var borderColor by remember { mutableStateOf<Color?>(null)}

                    if(!multipleSelectionEnabled){
                        isSelected = item == selectedItem
                    }

                    if(isSelected){
                        gridIconSize = 60.dp
                        gridBoxBorder = 2.dp

                        borderColor = MaterialTheme.colors.primary
                    }else{
                        gridIconSize = 50.dp
                        gridBoxBorder = 1.dp

                        borderColor = MaterialTheme.colors.onSecondary
                    }

                    Column(
                        modifier = Modifier
                            .border(
                                gridBoxBorder,
                                borderColor!!
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .clickable {
                                    if (multipleSelectionEnabled) {
                                        isSelected = !isSelected
                                        selectedItemList = listOf(item)
                                    } else {
                                        selectedItem = item
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ){

                            Icon(
                                modifier = Modifier
                                    .size(gridIconSize),
                                painter = rememberImagePainter(data = item.imageResource),
                                contentDescription = null,
                                tint = borderColor!!)
                        }

                        Box(
                            modifier = Modifier
                                .size(80.dp, 20.dp),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Text(
                                text = item.title,
                                textAlign = TextAlign.Center,
                                color = borderColor!!,
                                style = MaterialTheme.typography.caption.copy(
                                    fontWeight = FontWeight.ExtraBold
                                )
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .padding(2.dp),
                        contentAlignment = Alignment.TopStart
                    ){
                        CircleCheckbox(selected = isSelected)
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

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

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = underButtonHintText,
            style = MaterialTheme.typography.body2
        )
    }
}
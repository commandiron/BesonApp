package com.example.besonapp.presentation.screens.signup_steps.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
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
import com.example.besonapp.presentation.common_components.CustomCircleCheckbox
import com.example.besonapp.presentation.common_components.CustomButton
import com.example.besonapp.presentation.model.ConstructionItem
import com.example.besonapp.presentation.ui.theme.LOWER_VISIBILITY_ALPHA
import com.example.besonapp.presentation.ui.theme.primaryColorNoTheme
import com.example.besonapp.util.*

@Composable
fun SignUpStepsCategorySelectionPage(
    title: String,
    underButtonHintText: String = "",
    itemListMain: List<ConstructionItem>,
    buttonText: String,
    multipleSelectionEnabled: Boolean,
    onNextButtonClickSingleSelection: ((ConstructionItem?) -> Unit)? = null,
    onNextButtonClickMultipleSelection: ((List<ConstructionItem>?) -> Unit)? = null
){
    var selectedItemList by remember { mutableStateOf<List<ConstructionItem>?>(null) }
    var selectedItem by remember { mutableStateOf<ConstructionItem?>(null) }

    val lazyGridState = rememberLazyGridState()

    Column(
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.height(20.dp),
            text = title,
            color = MaterialTheme.colors.onBackground.copy(LOWER_VISIBILITY_ALPHA),
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(20.dp))

        var gridIconSize by remember { mutableStateOf(80.dp)}
        var gridBoxBorder by remember { mutableStateOf(1.dp)}

        //BURADA BİR PROBLEM VAR PATLIYOR BAKILACAK.
        LazyVerticalGrid(
            state = lazyGridState,
            modifier = Modifier
                .wrapContentWidth()
                .height(330.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            userScrollEnabled = true,
            columns = GridCells.Fixed(3),
            content = {
                items(itemListMain){ item ->
                    var isSelected by remember { mutableStateOf(false)}
                    var borderColor by remember { mutableStateOf<Color?>(null)}

                    if(!multipleSelectionEnabled){
                        isSelected = item == selectedItem
                    }
                    if(isSelected){
                        gridIconSize = 60.dp
                        gridBoxBorder = 2.dp

                        borderColor = primaryColorNoTheme
                    }else{
                        gridIconSize = 50.dp
                        gridBoxBorder = 1.dp

                        borderColor = MaterialTheme.colors.onBackground
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
                                        if(isSelected){
                                            if(selectedItemList != null){
                                                selectedItemList = selectedItemList!! + listOf(item)
                                            }else{
                                                selectedItemList = listOf(item)
                                            }
                                        }else{
                                            selectedItemList = selectedItemList!! - listOf(item)
                                        }
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
                                tint = borderColor!!
                            )
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
                        CustomCircleCheckbox(selected = isSelected)
                    }
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomButton(
            onClick = {
                if(multipleSelectionEnabled){
                    onNextButtonClickMultipleSelection!!.invoke(selectedItemList)
                }else{
                    onNextButtonClickSingleSelection!!.invoke(selectedItem)
                }
            }
        ) {
            Text(text = buttonText)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = underButtonHintText,
            color = MaterialTheme.colors.onBackground.copy(LOWER_VISIBILITY_ALPHA),
            style = MaterialTheme.typography.body2
        )
    }
    //Scroll bar
    if(itemListMain.size > 9){
        val minPercentage: Double
        if(itemListMain.size < 9){
            minPercentage = 0.9
        }else{
            val invisibleItemCount = itemListMain.size - 9
            val invisibleLineCount = Math.ceil(invisibleItemCount / 3.0)
            minPercentage = 0.9 - invisibleLineCount/10
        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopEnd
        ) {
            val lazyListState = rememberLazyListState()
            Carousel(
                state = lazyListState,
                totalLength = 276,
                modifier = Modifier
                    .size(2.dp, 330.dp)
                    .padding(top = 100.dp),
                minPercentage = minPercentage.toFloat(),
                maxPercentage = 0.9f,
                colors = CarouselDefaults.colors(
                    scrollingThumbColor = primaryColorNoTheme,
                    scrollingBackgroundColor = MaterialTheme.colors.onBackground),
                scrolled = {lazyGridState.firstVisibleItemScrollOffset}
            )
        }
    }else{
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopEnd
        ) {
            Divider(
                modifier = Modifier
                    .size(2.dp, 330.dp)
                    .padding(top = 100.dp),
                color = primaryColorNoTheme
            )
        }
    }
}
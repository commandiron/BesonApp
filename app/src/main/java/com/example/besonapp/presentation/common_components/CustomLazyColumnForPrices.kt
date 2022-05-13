package com.example.besonapp.presentation.common_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.besonapp.presentation.model.ConstructionPriceItem
import com.example.besonapp.presentation.ui.theme.primaryColorNoTheme
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CustomLazyColumnForPrices(
    listOfConstructionPriceItem: List<ConstructionPriceItem>,
    onUsernameClick:() -> Unit
) {
    val sdf = remember { SimpleDateFormat( "dd/MM/yyyy", Locale.ROOT) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        items(listOfConstructionPriceItem){ item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier
                            .weight(1f)
                        ) {
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
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Text(
                                text = item.price.toString() + " TL/" + item.unit,
                                style = MaterialTheme.typography.h3
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp, vertical = 10.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Row {
                        val interactionSource = remember { MutableInteractionSource() }
                        Text(
                            text = "Gönderen: ",
                            style = MaterialTheme.typography.caption)
                        Text(
                            modifier = Modifier.clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ){
                                onUsernameClick()
                            },
                            text = item.userByName,
                            style = MaterialTheme.typography.caption,
                            color = primaryColorNoTheme
                        )
                    }
                }
            }
        }
    }
}
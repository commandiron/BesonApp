package com.example.besonapp.presentation.common_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberImagePainter
import com.example.besonapp.R

@Composable
fun CustomAlertDialogForShowProfile(
    mainConstructionCategoryTitles: List<String>,
    subConstructionCategoryTitles: List<String>,
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
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Demirli İnşaat San. Tic. Ltd. Şti.",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    text = "Tel: 0535 508 55 52",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Ana Faaliyet Alanı:",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground
                )
                Divider(modifier = Modifier.padding(horizontal = 10.dp), color = MaterialTheme.colors.onPrimary, thickness = 1.dp)
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(mainConstructionCategoryTitles){ item ->
                        Text(
                            text = item,
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Uzmanlık Alanları",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground
                )
                Divider(modifier = Modifier.padding(horizontal = 10.dp), color = MaterialTheme.colors.onPrimary, thickness = 1.dp)
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    items(subConstructionCategoryTitles){ item ->
                        Text(
                            text = item,
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
        }
    }
}
package com.example.besonapp.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.besonapp.presentation.common_components.ConstructionItemView
import com.example.besonapp.presentation.common_components.CustomTextFieldComponent2
import com.example.besonapp.presentation.model.MainConstructionItem
import com.example.besonapp.presentation.navigation.NavigationItem

@Composable
fun EditProfileScreen(
    navController: NavController,
){

    var name by remember { mutableStateOf("")}
    val hintName by remember { mutableStateOf("İsim")}

    val phoneNumber by remember { mutableStateOf("")}
    val hintPhoneNumber by remember { mutableStateOf("Telefon Numarası")}

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(vertical = 52.dp, horizontal = 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        modifier = Modifier.clickable {
                            navController.navigate(NavigationItem.Profile.screen_route)
                        },
                        text = "İptal",
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium),
                        textAlign = TextAlign.Center
                    )
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    ClickableToGalleryImage()
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        modifier = Modifier.clickable {
                            //Viewmodel'den kaydetme işlemi yapılacak.
                        },
                        text = "Kaydet",
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Normal),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            CustomTextFieldComponent2(
                modifier = Modifier.fillMaxWidth(),
                input = name,
                hint = hintName){
                name = it
            }

            CustomTextFieldComponent2(
                modifier = Modifier.fillMaxWidth(),
                input = phoneNumber,
                hint = hintPhoneNumber,
                keyboardType = KeyboardType.Phone){
                name = it
            }

            Spacer(modifier = Modifier.height(10.dp))
            
            Text(
                text = "Ana Faaliyet Kategorisi",
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.body1)

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                color = MaterialTheme.colors.onPrimary,
                thickness = 1.dp
            )

            //Bu kısım viewmodelden kullanıcı profili olarak gelecek.
            val data = MainConstructionItem.createMainCategories()[6]

            Box(
            ) {
                ConstructionItemView(data = data)
            }


            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Uzmanlık Alan(lar)ı",
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.body1)

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                color = MaterialTheme.colors.onPrimary,
                thickness = 1.dp
            )

            //Bu kısım viewmodelden kullanıcı profili olarak gelecek.
            val dataList = data.subConstructionCategories ?: emptyList()

            LazyVerticalGrid(
                modifier = Modifier.heightIn(max = 100.dp),
                columns = GridCells.Fixed(4),
                horizontalArrangement = Arrangement.Center){

                items(dataList){ item ->

                    ConstructionItemView(data = item)
                }
            }
        }
    }
}
































package com.example.besonapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.besonapp.presentation.CustomAppExplainingTape
import com.example.besonapp.presentation.CustomCustomerOrCompanyContent
import com.example.besonapp.presentation.CustomLogoAnimationForCustomerOrCompanyScreen
import com.example.besonapp.presentation.util.StaticTexts.APP_STATEMENT
import com.example.besonapp.ui.theme.selectCustomerOrCompanyScreenColor1
import com.example.besonapp.ui.theme.selectCustomerOrCompanyScreenColor2

@Composable
fun SelectCustomerOrCompanyScreen(navController: NavController) {


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Surface(
                modifier = Modifier
                    .weight(1f),
                color = selectCustomerOrCompanyScreenColor1
            ) {

                val matrix = ColorMatrix()
                matrix.setToSaturation(0F)

                Image(
                    painter =
                    rememberImagePainter(
                        request =ImageRequest
                            .Builder(LocalContext.current)
                            .data("https://archello.s3.eu-central-1.amazonaws.com/images/2021/02/28/addline-group-interior-design-of-the-construction-company-office-offices-archello.1614525239.7456.jpg").build() ),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    colorFilter = ColorFilter.colorMatrix(matrix),
                    alpha= 0.1f)

                CustomCustomerOrCompanyContent(
                    title = "MÜŞTERİYİM",
                    details = "Fiyat görmek ve taşeron firma bulmak istiyorum.",
                    button = "GİRİŞ YAP"){
                    navController.navigate(NavigationItem.LogIn.screenRoute)
                }
            }

            Surface(
                modifier = Modifier
                    .weight(1f),
                color = selectCustomerOrCompanyScreenColor2
            ) {

                val matrix = ColorMatrix()
                matrix.setToSaturation(0F)
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter =
                    rememberImagePainter(
                        request =ImageRequest
                            .Builder(LocalContext.current)
                            .data("https://assets.bizclikmedia.net/668/1c6647d96a362cc2ce8db0361b509e77:0b0fab1f532a05d304b7611bb9a475f5/mace1-jpeg.webp").build()),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    colorFilter = ColorFilter.colorMatrix(matrix),
                    alpha= 0.1f)


                CustomCustomerOrCompanyContent(
                    title = "FİRMAYIM",
                    details = "Fiyat güncellemek ve müşteri bulmak istiyorum.",
                    button = "GİRİŞ YAP"){
                    navController.navigate(NavigationItem.LogIn.screenRoute)
                }
            }

            Surface(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                color = selectCustomerOrCompanyScreenColor2
            ) {
                CustomAppExplainingTape(APP_STATEMENT)
            }
        }

        CustomLogoAnimationForCustomerOrCompanyScreen() //BU LOGO ANİMASYONUNU APP'İN HERYERİNDEN ULAŞILABİLCEK ŞEKİLDE YAPMAYA ÇALIŞACAĞIM.
    }
}
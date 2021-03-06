package com.example.besonapp.presentation.screens.signup_steps_as_customer.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.besonapp.R
import com.example.besonapp.presentation.common_components.CustomButton
import com.example.besonapp.presentation.ui.theme.LOWER_VISIBILITY_ALPHA

@Composable
fun SignUpStepsClickableToGalleryImagePage(
    modifier: Modifier = Modifier,
    title: String,
    buttonText: String,
    size: Dp = 100.dp,
    onClick:(Uri?) -> Unit = {}
){
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.onBackground.copy(LOWER_VISIBILITY_ALPHA),
            style = MaterialTheme.typography.body1
        )
        Image(
            painter = rememberImagePainter(
                data = if(imageUri!=null)imageUri else R.drawable.ic_blank_profile_picture),
            contentDescription = null,
            modifier = Modifier
                .clickable { launcher.launch("image/*") }
                .size(size)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape),
            contentScale = ContentScale.Crop
        )
        CustomButton(
            onClick = {
                onClick(imageUri)
            }
        ) {
            Text(text = buttonText)
        }
    }
}
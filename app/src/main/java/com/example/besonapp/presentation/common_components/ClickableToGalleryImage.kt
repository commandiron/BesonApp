package com.example.besonapp.presentation.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.besonapp.R

@Composable
fun ClickableToGalleryImage(
    size: Dp = 100.dp){

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

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
}
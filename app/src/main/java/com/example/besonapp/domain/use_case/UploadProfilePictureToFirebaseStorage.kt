package com.example.besonapp.domain.use_case

import android.net.Uri
import com.example.besonapp.domain.repository.AppRepository

class UploadProfilePictureToFirebaseStorage(
    private val repository: AppRepository
) {
    suspend operator fun invoke(uri: Uri) = repository.uploadProfilePictureToFirebaseStorage(uri)
}
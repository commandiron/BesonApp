package com.example.besonapp.data.repository

import android.net.Uri
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.besonapp.domain.model.CompanyProfile
import com.example.besonapp.domain.model.CustomerProfile
import com.example.besonapp.domain.repository.AppRepository
import com.example.besonapp.util.Response
import com.example.besonapp.presentation.model.UserType
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor (
    private val auth: FirebaseAuth,
    private val databaseFirebase: FirebaseDatabase,
    private val storageFirebase: FirebaseStorage,
    private val dataStore: DataStore<Preferences>,
): AppRepository {
    override suspend fun setUserOpenAppOnceFlagForShowSplashAndIntroScreens() {
        dataStore.edit { user_preferences ->
            user_preferences[booleanPreferencesKey("isUserOpenAppOnce")] = true
        }
    }
    override suspend fun getUserOpenAppOnceFlag(): Flow<Boolean> {
        val key = booleanPreferencesKey("isUserOpenAppOnce")
        val data = dataStore.data.map{
            it[key] ?: false
        }
        return data
    }
    override suspend fun setUserPassTutorialOnceFlag() {
        dataStore.edit { user_preferences ->
            user_preferences[booleanPreferencesKey("isUserPassTutorialOnce")] = true
        }
    }
    override suspend fun getUserPassTutorialOnceFlag(): Flow<Boolean> {
        val key = booleanPreferencesKey("isUserPassTutorialOnce")
        val data = dataStore.data.map{
            it[key] ?: false
        }
        return data
    }
    override suspend fun signUp(email: String, password: String): Flow<Response<Boolean>> = callbackFlow {
        try {
            send(Response.Loading)
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                if(it.user != null){
                    trySend(Response.Success(true))
                }
            }.addOnFailureListener {
                trySend(Response.Error(it.message ?: "ERROR_MESSAGE"))
            }
            awaitClose {
                channel.close()
                cancel()
            }
        } catch (e: Exception) {
            trySend(Response.Error(e.message ?: "ERROR_MESSAGE"))
        }
    }
    override suspend fun createUserProfileToFirebaseDb(userType: UserType): Flow<Response<Boolean>> = callbackFlow {
        try {
            send(Response.Loading)

            val profileUid = auth.currentUser?.uid.toString()

            val databaseReference = databaseFirebase.getReference("Profiles").child(userType.toString()).child(profileUid)

            val childUpdates = mutableMapOf<String,Any>()

            childUpdates.put("/profileUid/", profileUid)

            databaseReference.updateChildren(childUpdates).addOnSuccessListener {
                trySend(Response.Success(true))
            }.addOnFailureListener {
                trySend(Response.Error(it.message ?: "ERROR_MESSAGE"))
            }
            awaitClose {
                channel.close()
                cancel()
            }
        }catch (e: Exception){
            send(Response.Error(e.message ?: "ERROR_MESSAGE"))
        }
    }
    override suspend fun logIn(email: String, password: String): Flow<Response<Boolean>> = callbackFlow{
        try {
            send(Response.Loading)
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                if(it.user != null){
                    trySend(Response.Success(true))
                }
            }.addOnFailureListener {
                trySend(Response.Error(it.message ?: "ERROR_MESSAGE"))
            }
            awaitClose {
                channel.close()
                cancel()
            }
        } catch (e: Exception) {
            trySend(Response.Error(e.message ?: "ERROR_MESSAGE"))
        }
    }

    override suspend fun uploadProfilePictureToFirebaseStorage(uri: Uri): Flow<Response<String>> = callbackFlow {
        try {
            send(Response.Loading)
            val uuidImage = UUID.randomUUID()
            val imageName = "images/$uuidImage.jpg"
            val storageRef = storageFirebase.reference.child(imageName)
            storageRef.putFile(uri).addOnSuccessListener {
                storageRef.downloadUrl.addOnSuccessListener {
                    val downloadUrl = it.toString()
                    trySend(Response.Success(downloadUrl))
                }.addOnFailureListener {
                    trySend(Response.Error(it.message ?: "ERROR_MESSAGE"))
                }
            }.addOnFailureListener{
                trySend(Response.Error(it.message ?: "ERROR_MESSAGE"))
            }
            awaitClose {
                channel.close()
                cancel()
            }
        } catch (e: Exception) {
            trySend(Response.Error(e.message ?: "ERROR_MESSAGE"))
        }
    }
    override suspend fun updateCustomerProfileToFirebaseDb(customerProfile: CustomerProfile): Flow<Response<Boolean>> = callbackFlow {
        try {
            send(Response.Loading)

            val profileUid = auth.currentUser?.uid.toString()

            val databaseReference = databaseFirebase.getReference("Profiles").child(UserType.CUSTOMER.toString()).child(profileUid)

            val childUpdates = mutableMapOf<String,Any>()
            childUpdates["/profileUid/"] = profileUid
            childUpdates["/name/"] = customerProfile.name
            childUpdates["/phoneNumber/"] = customerProfile.phoneNumber
            childUpdates["/profilePictureUrl/"] = customerProfile.profilePictureUrl

            databaseReference.updateChildren(childUpdates).addOnSuccessListener {
                trySend(Response.Success(true))
            }.addOnFailureListener {
                trySend(Response.Error(it.message ?: "ERROR_MESSAGE"))
            }
            awaitClose {
                channel.close()
                cancel()
            }
        }catch (e: Exception){
            send(Response.Error(e.message ?: "ERROR_MESSAGE"))
        }
    }
    override suspend fun updateCompanyProfileToFirebaseDb(companyProfile: CompanyProfile): Flow<Response<Boolean>> = callbackFlow {
        try {
            send(Response.Loading)

            val profileUid = auth.currentUser?.uid.toString()

            val databaseReference = databaseFirebase.getReference("Profiles").child(UserType.COMPANY.toString()).child(profileUid)

            val childUpdates = mutableMapOf<String,Any>()
            childUpdates["/profileUid/"] = profileUid
            childUpdates["/name/"] = companyProfile.name
            childUpdates["/phoneNumber/"] = companyProfile.phoneNumber
            childUpdates["/profilePictureUrl/"] = companyProfile.profilePictureUrl
            childUpdates["/mainConstructionItemId/"] = companyProfile.mainConstructionItemId
            childUpdates["/subConstructionItemIdList/"] = companyProfile.subConstructionItemIdList

            databaseReference.updateChildren(childUpdates).addOnSuccessListener {
                trySend(Response.Success(true))
            }.addOnFailureListener {
                trySend(Response.Error(it.message ?: "ERROR_MESSAGE"))
            }
            awaitClose {
                channel.close()
                cancel()
            }
        }catch (e: Exception){
            send(Response.Error(e.message ?: "ERROR_MESSAGE"))
        }
    }
}
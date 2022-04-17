package com.example.besonapp.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ConstructionItem(
    val id: Int = 0,
    val title: String = "",
    val icon: ImageVector = Icons.Default.CarCrash,
    var isSelected: Boolean = false
){
    object Kazi: ConstructionItem(
        id = 0,
        title = "Kazi İşleri"
    ){

        object Iksa: ConstructionItem(
            id = 8,
            title = "İksa İşleri"
        )
        object Hafriyat: ConstructionItem(
            id = 9,
            title = "Hafriyat İşleri"
        )
    }

    object KabaYapi: ConstructionItem(
        id = 1,
        title = "Kaba Yapi İşleri"
    ){
        object Beton: ConstructionItem(
            id = 10,
            title = "Beton"
        )
        object Demir: ConstructionItem(
            id = 11,
            title = "Demir"
        )
        object Kalip: ConstructionItem(
            id = 12,
            title = "Kalıp"
        )
        object BetonDemirKalipIscilik: ConstructionItem(
            id = 13,
            title = "Beton Demir Kalıp İşçilik"
        )

    }

    object Cati: ConstructionItem(
        id = 2,
        title = "Çatı İşleri"
    ){
    }

    object Cephe: ConstructionItem(
        id = 3,
        title = "Cephe İşleri"
    )

    object MekanikTesisat: ConstructionItem(
        id = 4,
        title = "Mekanik Tesisat İşleri"
    )

    object ElektrikTesisat: ConstructionItem(
        id = 5,
        title = "Elektrik Tesisat İşleri"
    )

    object IcImalatlar: ConstructionItem(
        id = 6,
        title = "İç İmalatlar"
    )

    object PeysajVeCevreDuzenlemesi: ConstructionItem(
        id = 7,
        title = "Peysaj ve Çevre Düzenlemesi İşleri"
    )



    companion object{

        //Create static data for construction catagories.

        fun createMainCatagoryList(): List<ConstructionItem>{
            val categoryList = listOf(
                Kazi,
                KabaYapi,
                Cati,
                Cephe,
                MekanikTesisat,
                ElektrikTesisat,
                IcImalatlar,
                PeysajVeCevreDuzenlemesi
            )
            return categoryList
        }
        fun createSubCatagoryList(): HashMap<Int, List<ConstructionItem>>{

            val subCatagoryList = hashMapOf<Int, List<ConstructionItem>>()

            subCatagoryList.put(Kazi.id,
                listOf(
                    Kazi.Iksa,
                    Kazi.Hafriyat
                )
            )

            subCatagoryList.put(KabaYapi.id,
                listOf(
                    KabaYapi.Beton,
                    KabaYapi.Demir,
                    KabaYapi.Kalip,
                    KabaYapi.BetonDemirKalipIscilik
                )
            )

            return subCatagoryList
        }
    }
}


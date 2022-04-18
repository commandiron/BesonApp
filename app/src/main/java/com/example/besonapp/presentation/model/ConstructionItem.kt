package com.example.besonapp.presentation.model

import com.example.besonapp.R

sealed class ConstructionItem(
    val id: Int = 0,
    val title: String = "",
    val imageResource: Int = R.drawable.my_launcher_icon_foreground,
    var isSelected: Boolean = false
){
    object Kazi: ConstructionItem(
        id = 0,
        title = "Kazi İşleri",
        imageResource = R.drawable.construction_item_kazi
    ){

        object Iksa: ConstructionItem(
            id = 8,
            title = "İksa İşleri",
            imageResource = R.drawable.construction_item_iksa
        )
        object Hafriyat: ConstructionItem(
            id = 9,
            title = "Hafriyat İşleri",
            imageResource = R.drawable.construction_item_hafriyat
        )
    }

    object KabaYapi: ConstructionItem(
        id = 1,
        title = "Kaba Yapi İşleri",
        imageResource = R.drawable.construction_item_kaba_yapi
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
        title = "Çatı İşleri",
        imageResource = R.drawable.construction_item_cati
    ){
    }

    object Cephe: ConstructionItem(
        id = 3,
        title = "Cephe İşleri",
        imageResource = R.drawable.construction_item_cephe
    )

    object MekanikTesisat: ConstructionItem(
        id = 4,
        title = "Mekanik Tesisat İşleri",
        imageResource = R.drawable.construction_item_mekanik_tesisat
    )

    object ElektrikTesisat: ConstructionItem(
        id = 5,
        title = "Elektrik Tesisat İşleri",
        imageResource = R.drawable.construction_item_elektrik_tesisat
    )

    object IcImalatlar: ConstructionItem(
        id = 6,
        title = "İç İmalatlar",
        imageResource = R.drawable.construction_item_ic_imalatlar
    )

    object PeysajVeCevreDuzenlemesi: ConstructionItem(
        id = 7,
        title = "Peysaj ve Çevre Düzenlemesi İşleri",
        imageResource = R.drawable.construction_item_peysaj_ve_cevre
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


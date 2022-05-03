package com.example.besonapp.presentation.model

import com.example.besonapp.R

class MainConstructionItem(
    title: String,
    imageResource: Int? = null,
    val subConstructionCategories: List<SubConstructionItem>? = null
) : ConstructionItem(title, imageResource) {
    
    companion object {
        val kazi = MainConstructionItem(
            title = "Kazi İşleri",
            imageResource = R.drawable.construction_item_kazi,
            subConstructionCategories = listOf(
                SubConstructionItem.iksaIsleri,
                SubConstructionItem.hafriyatIsleri
            )
        )
        val kabaYapi = MainConstructionItem(
            title = "Kaba Yapi İşleri",
            imageResource = R.drawable.construction_item_kaba_yapi,
            subConstructionCategories = listOf(
                SubConstructionItem.beton,
                SubConstructionItem.demir,
                SubConstructionItem.kalip,
                SubConstructionItem.betonDemirKalip,
                SubConstructionItem.duvar,
                SubConstructionItem.izolasyon,
                SubConstructionItem.digerKabaInsaatMalzeme,
                SubConstructionItem.betonKesmeDelme
            )
        )
        val cati = MainConstructionItem(
            title = "Çatı İşleri",
            imageResource = R.drawable.construction_item_cati,
            subConstructionCategories = listOf(
                SubConstructionItem.kompleCati,
                SubConstructionItem.baca
            )
        )
        val cephe = MainConstructionItem(
            title = "Cephe İşleri",
            imageResource = R.drawable.construction_item_cephe,
            subConstructionCategories = listOf(
                SubConstructionItem.cepheKaplamaSistemi,
                SubConstructionItem.cepheIskele
            )
        )
        val mekanikTesisat = MainConstructionItem(
            title = "Mekanik Tesisat İşleri",
            imageResource = R.drawable.construction_item_mekanik_tesisat,
            subConstructionCategories= listOf(
                SubConstructionItem.sihhiTesisatIsleri,
                SubConstructionItem.sogutmaKlimaSistemi,
                SubConstructionItem.havalandirmaSistemi,
                SubConstructionItem.mekanikMontaj,
                SubConstructionItem.asansor
            )
        )
        val elektrikTesisat = MainConstructionItem(
            title = "Elektrik Tesisat İşleri",
            imageResource = R.drawable.construction_item_elektrik_tesisat,
            subConstructionCategories = listOf(
                SubConstructionItem.gucDagitimSistemi,
                SubConstructionItem.aydinlatmaIsiklandirmaSistemi,
                SubConstructionItem.iletisimSistemi,
                SubConstructionItem.guvenlikSistemi,
                SubConstructionItem.yedekGucSistemi
            )
        )
        val icImalatlar = MainConstructionItem(
            title = "İç İmalatlar",
            imageResource = R.drawable.construction_item_ic_imalatlar,
            subConstructionCategories = listOf(
                SubConstructionItem.siva,
                SubConstructionItem.boyaBadana,
                SubConstructionItem.icMekanIzolasyon,
                SubConstructionItem.alcipanKartonpiyer,
                SubConstructionItem.sap,
                SubConstructionItem.metalKorkuluk,
                SubConstructionItem.mermer,
                SubConstructionItem.seramik,
                SubConstructionItem.parke,
                SubConstructionItem.kapiPencereBalkon,
                SubConstructionItem.mutfak
            )
        )
        val peysajVeCevre = MainConstructionItem(
            title = "Peysaj ve Çevre Düzenlemesi İşleri",
            imageResource = R.drawable.construction_item_peysaj_ve_cevre,
            subConstructionCategories = listOf(
                SubConstructionItem.bahce
            )
        )

        fun createMainCategories(): List<MainConstructionItem> {
            return listOf(
                kazi,
                kabaYapi,
                cati,
                cephe,
                mekanikTesisat,
                elektrikTesisat,
                icImalatlar,
                peysajVeCevre
            )
        }
    }
}
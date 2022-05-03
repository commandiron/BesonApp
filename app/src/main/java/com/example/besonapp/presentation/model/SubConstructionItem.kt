package com.example.besonapp.presentation.model

import com.example.besonapp.R

class SubConstructionItem(
    title: String,
    imageResource: Int? = null,
    val priceCategories: List<ConstructionPriceItem>? = null
) : ConstructionItem(title, imageResource){
    
    companion object{

        //Kazi İşleri

        val iksaIsleri = SubConstructionItem(
            title = "İksa İşleri",
            imageResource = R.drawable.construction_item_iksa,
            priceCategories = listOf(
                ConstructionPriceItem(id = 0, title = "ShutCrete Yapılması", unit = "m²"),
                ConstructionPriceItem(id = 1, "Fore Kazık Yapılması", unit = "m")
            )
        )
        val hafriyatIsleri = SubConstructionItem(
            title = "Hafriyat İşleri",
            imageResource = R.drawable.construction_item_hafriyat,
            priceCategories = listOf(
                ConstructionPriceItem(id = 2, title = "Kazı Yapılması", unit = "m³")
            )
        )

        // Kaba Yapı İşleri

        val beton = SubConstructionItem(
            title = "Beton",
            imageResource = R.drawable.construction_item_beton,
            priceCategories = listOf(
                ConstructionPriceItem(id = 3, title = "C30 Beton Dökülmesi", unit = "m³")
            )
        )
        val demir = SubConstructionItem(
            title = "Demir",
            imageResource = R.drawable.construction_item_demir,
            priceCategories = listOf(
                ConstructionPriceItem(id = 4, title = "İnşaat Demiri", unit = "ton")
            )
        )
        val kalip = SubConstructionItem(
            title = "Kalıp",
            imageResource = R.drawable.construction_item_kalip,
            priceCategories = listOf(
                ConstructionPriceItem(id = 5, title = "Kalıp Yapılması", unit = "m²")
            )
        )
        val betonDemirKalip = SubConstructionItem(
            title = "Beton, Demir, Kalıp İşçilik",
            imageResource = R.drawable.construction_item_beton_demir_kalip_islicik,
            priceCategories = listOf(
                ConstructionPriceItem(id = 6, title = "Beton, Demir, Kalıp İşçilik", unit = "m²")
            )
        )
        val duvar = SubConstructionItem(
            title = "Duvar",
            imageResource = R.drawable.construction_item_duvar,
            priceCategories = listOf(
                ConstructionPriceItem(id = 7, title = "Duvar Örülmesi", unit = "m²")
            )
        )
        val izolasyon = SubConstructionItem(
            title = "İzolasyon",
            imageResource = R.drawable.construction_item_izolasyon,
            priceCategories = listOf(
                ConstructionPriceItem(id = 8, title = "Temel İzolasyon Yapılması", unit = "m²"),
                ConstructionPriceItem(id = 9, title = "Perde İzolasyon Yapılması", unit = "m²")
            )
        )
        val digerKabaInsaatMalzeme = SubConstructionItem(
            title = "Kaba İnşaat Malzemeleri",
            imageResource = R.drawable.construction_item_diger_kaba_insaat_malzeme,
            priceCategories = listOf(
                ConstructionPriceItem(id = 10, title = "EPS Asmolen Malzemesi", unit = "m³")
            )
        )
        val betonKesmeDelme = SubConstructionItem(
            title = "Beton Kesme ve Delme (Karot)",
            imageResource = R.drawable.construction_item_karot,
            priceCategories = listOf(
                ConstructionPriceItem(id = 11, title = "24-52 mm Çaplı Karot Alınması", unit = "cm")
            )
        )

        // Çatı İşleri

        val kompleCati = SubConstructionItem(
            title = "Komple Çatı İmalatı",
            imageResource = R.drawable.construction_item_komple_cati_imalati,
            priceCategories = listOf(
                ConstructionPriceItem(id = 12, title = "Komple Çatı Yapılması", unit = "m²")
            )
        )

        val baca = SubConstructionItem(
            title = "Baca",
            imageResource = R.drawable.construction_item_baca,
            priceCategories = listOf(
                ConstructionPriceItem(id = 13, title = "Baca Yapılması", unit = "m")
            )
        )

        // Cephe İşleri

        val cepheKaplamaSistemi = SubConstructionItem(
            title = "Cephe Kaplama",
            imageResource = R.drawable.construction_item_cephe_kaplama,
            priceCategories = listOf(
                ConstructionPriceItem(id = 14, title = "Sinterflex Cephe Kaplaması", unit = "m²"),
                ConstructionPriceItem(id = 15, title = "Kompozit Cephe Kaplaması", unit = "m²")
            )
        )
        val cepheIskele = SubConstructionItem(
            title = "Cephe İskele",
            imageResource = R.drawable.construction_item_iskele,
            priceCategories = listOf(
                ConstructionPriceItem(id = 16, title = "Cephe İskelesi Kurulması", unit = "m²/ay")
            )
        )

        // Mekanik Tesisat İşleri

        val sihhiTesisatIsleri = SubConstructionItem(
            title = "Sıhhi Tesisat İşleri",
            imageResource = R.drawable.construction_item_sihhi_tesisat_isleri,
            priceCategories = listOf(
                ConstructionPriceItem(id = 17, title = "100 m2 Daire Sıhhi Tesisat İşleri", unit = "gtr")
            )
        )
        val sogutmaKlimaSistemi = SubConstructionItem(
            title = "Soğutma ve Klima Sistemi",
            imageResource = R.drawable.construction_item_sogutma_klima_sistemi,
            priceCategories = listOf(
                ConstructionPriceItem(id = 18, title = "100 m2 Daire Klima İşleri", unit = "gtr")
            )
        )
        val havalandirmaSistemi = SubConstructionItem(
            title = "Havalandırma Sistemi",
            imageResource = R.drawable.construction_item_havalandirma_sistemi,
            priceCategories = listOf(
                ConstructionPriceItem(id = 19, title = "1000 m2 Bodrum Havalandırma İşleri", unit = "gtr")
            )
        )
        val mekanikMontaj = SubConstructionItem(
            title = "Montaj",
            imageResource = R.drawable.construction_item_montaj,
            priceCategories = listOf(
                ConstructionPriceItem(id = 20, title = "Klozet", unit = "ad"),
                ConstructionPriceItem(id = 21, title = "Lavabo", unit = "ad"),
                ConstructionPriceItem(id = 22, title = "Batarya", unit = "ad")
            )
        )
        val asansor = SubConstructionItem(
            title = "Asansör",
            imageResource = R.drawable.construction_item_asansor,
            priceCategories = listOf(
                ConstructionPriceItem(id = 23, title = "10 Duraklı 5 Kişilik Asansör Yapılması", unit = "gtr")
            )
        )

        //Elektrik Tesisat İşleri

        val gucDagitimSistemi = SubConstructionItem(
            title = "Güç Dagitim Sistemi",
            imageResource = R.drawable.construction_item_guc_dagitim_sistemi,
            priceCategories = listOf(
                ConstructionPriceItem(id = 24, title = "100 m2 Daire Güç Dağıtım Sistemi İşleri", unit = "gtr")
            )
        )
        val aydinlatmaIsiklandirmaSistemi = SubConstructionItem(
            title = "Aydınlatma Işıklandırma Sistemi",
            imageResource = R.drawable.construction_item_aydinlatma_ve_isiklandirma_sistemi,
            priceCategories = listOf(
                ConstructionPriceItem(id = 25, title = "100 m2 Daire Aydınlatma İşleri", unit = "gtr")
            )
        )
        val iletisimSistemi = SubConstructionItem(
            title = "İletişim Sistemi",
            imageResource = R.drawable.construction_item_iletisim_sistemi,
            priceCategories = listOf(
                ConstructionPriceItem(id = 26, title = "20 Daireli Apartman Diafon Sistemi", unit = "gtr")
            )
        )
        val guvenlikSistemi = SubConstructionItem(
            title = "Güvenlik Sistemi",
            imageResource = R.drawable.construction_item_guvenlik_sistemi,
            priceCategories = listOf(
                ConstructionPriceItem(id = 27, title = "20 Daireli Apartman Güvenlik Sistemi", unit = "gtr")
            )
        )
        val yedekGucSistemi = SubConstructionItem(
            title = "Yedek Güç Sistemi",
            imageResource = R.drawable.construction_item_yedek_guc_sistemi,
            priceCategories = listOf(
                ConstructionPriceItem(id = 28, title = "110 KW Jeneratör", unit = "gtr")
            )
        )

        //İç İmalatlar

        val siva = SubConstructionItem(
            title = "Siva",
            imageResource = R.drawable.construction_item_siva,
            priceCategories = listOf(
                ConstructionPriceItem(id = 29, title = "Alçı Sıva Yapılması", unit = "m²")
            )
        )
        val boyaBadana = SubConstructionItem(
            title = "Boya ve Badana",
            imageResource = R.drawable.construction_item_boya_badana,
            priceCategories = listOf(
                ConstructionPriceItem(id = 30, title = "Boya Yapılması", unit = "m²")
            )
        )
        val icMekanIzolasyon = SubConstructionItem(
            title = "İç Mekan İzolasyon",
            imageResource = R.drawable.construction_item_ic_mekan_izolasyon,
            priceCategories = listOf(
                ConstructionPriceItem(id = 31, title = "Sürme İzolasyon Yapılması", unit = "m²")
            )
        )
        val alcipanKartonpiyer = SubConstructionItem(
            title = "Alcipan ve Kartonpiyer",
            imageResource = R.drawable.construction_item_alcipan_kartonpiyer,
            priceCategories = listOf(
                ConstructionPriceItem(id = 32, title = "Alçıpan Yapılması", unit = "m²"),
                ConstructionPriceItem(id = 33, title = "Kartonpiyer Yapılması", unit = "m")
            )
        )
        val sap = SubConstructionItem(
            title = "Şap",
            imageResource = R.drawable.construction_item_sap,
            priceCategories = listOf(
                ConstructionPriceItem(id = 34, title = "7cm Kalınlığında Şap Yapılması", unit = "m²")
            )
        )
        val metalKorkuluk = SubConstructionItem(
            title = "Metal Korkuluk",
            imageResource = R.drawable.construction_item_metal_korkuluk,
            priceCategories = listOf(
                ConstructionPriceItem(id = 35, title = "Alüminyum Korkuluk Yapılması", unit = "m"),
                ConstructionPriceItem(id = 36, title = "Paslanmaz Korkuluk Yapılması", unit = "m")
            )
        )
        val mermer = SubConstructionItem(
            title = "Mermer",
            imageResource = R.drawable.construction_item_mermer,
            priceCategories = listOf(
                ConstructionPriceItem(id = 37, title = "Yerli Mermer", unit = "m²")
            )
        )
        val seramik = SubConstructionItem(
            title = "Seramik",
            imageResource = R.drawable.construction_item_seramik,
            priceCategories = listOf(
                ConstructionPriceItem(id = 38, title = "Yerli Seramik", unit = "m²")
            )
        )
        val parke = SubConstructionItem(
            title = "Parke",
            imageResource = R.drawable.construction_item_parke,
            priceCategories = listOf(
                ConstructionPriceItem(id = 39, title = "Yerli Lamine Parke", unit = "m²")
            )
        )
        val kapiPencereBalkon = SubConstructionItem(
            title = "Kapı, Pencere ve Balkon",
            imageResource = R.drawable.construction_item_kapi_pencere_balkon,
            priceCategories = listOf(
                ConstructionPriceItem(id = 40, title = "Alüminyum Doğrama", unit = "m²"),
                ConstructionPriceItem(id = 41, title = "PVC Doğrama", unit = "m²")
            )
        )
        val mutfak = SubConstructionItem(
            title = "Mutfak",
            imageResource = R.drawable.construction_item_mutfak,
            priceCategories = listOf(
                ConstructionPriceItem(id = 42, title = "Lake Mutfak Dolabı", unit = "m")
            )
        )

        //Peysaj

        val bahce = SubConstructionItem(
            title = "Bahce İşleri",
            imageResource = R.drawable.construction_item_bahce,
            priceCategories = listOf(
                ConstructionPriceItem(id = 43, title = "Çim", unit = "m²")
            )
        )
    }
}
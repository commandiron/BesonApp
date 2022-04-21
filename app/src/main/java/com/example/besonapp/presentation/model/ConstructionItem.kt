package com.example.besonapp.presentation.model

import com.example.besonapp.R

data class ConstructionItem(
    val id: Int? = null, //Her türlü id almalı daha sonra değiştirilecek.
    val title: String, //Her türlü title almalı
    val materialOrProcessTypes: List<String>? = null,
    val brandModelTypes: List<String>? = null,
    val measurementTypes: List<String>? = null,
    val unit: String? = null, //Unit almayabilir o yüzden null dedik
    val unitPriceAnalysis: String? = null,
    val imageResource: Int = R.drawable.my_launcher_icon_foreground, //Her türlü imageResource almalı, fakat hepsinin başka olmasına gerek yok başlangıç değeri verdik.
    val subCategories: List<ConstructionItem>? = null
){

    companion object{

        //Create static data for construction categories.

        //--Categories--

        //Kazi İşleri

        val iksaIsleri = ConstructionItem(
            title = "İksa İşleri",
            imageResource = R.drawable.construction_item_iksa,
            subCategories = listOf(
                ConstructionItem(title = "Fore Kazık Uygulaması"),
                ConstructionItem(title = "Shutcrete Uygulaması")
            )
        )
        val hafriyatIsleri = ConstructionItem(
            title = "Hafriyat İşleri",
            imageResource = R.drawable.construction_item_hafriyat,
            subCategories = listOf(
                ConstructionItem(title = "Hafriyat Yapılması"),
                ConstructionItem(title = "Kırıcı Çalıştırılması")
            )
        )

        // Kaba Yapı İşleri

        val beton = ConstructionItem(
            title = "Beton",
            imageResource = R.drawable.construction_item_beton,
            subCategories = listOf(
                ConstructionItem(title = "Yerinde Pompalı Beton Dökümü")
            )
        )
        val demir = ConstructionItem(
            title = "Demir",
            imageResource = R.drawable.construction_item_demir,
            subCategories = listOf(
                ConstructionItem(title = "Demir Malzeme"),
                ConstructionItem(title = "Demir İşçilik")
            )
        )
        val kalip = ConstructionItem(
            title = "Kalıp",
            imageResource = R.drawable.construction_item_kalip,
            subCategories = listOf(
                ConstructionItem(title = "Kalıp Malzeme"),
                ConstructionItem(title = "Kalıp İşçilik")
            )
        )
        val betonDemirKalip = ConstructionItem(
            title = "Beton, Demir, Kalıp İşçilik",
            imageResource = R.drawable.construction_item_beton_demir_kalip_islicik
        )
        val duvar = ConstructionItem(
            title = "Duvar",
            imageResource = R.drawable.construction_item_duvar,
            subCategories = listOf(
                ConstructionItem(title = "Duvar Malzeme"),
                ConstructionItem(title = "Duvar İşçilik")
            )
        )
        val izolasyon = ConstructionItem(
            title = "İzolasyon",
            imageResource = R.drawable.construction_item_izolasyon,
            subCategories = listOf(
                ConstructionItem(title = "Temel İzolasyonu"),
                ConstructionItem(title = "Perde İzolasyonu")
            )
        )
        val digerKabaInsaatMalzeme = ConstructionItem(
            title = "Kaba İnşaat Malzemeleri",
            imageResource = R.drawable.construction_item_diger_kaba_insaat_malzeme,
            subCategories = listOf(
                ConstructionItem(title = "Asmolen Döşeme Malzeme")
            )
        )
        val betonKesmeDelme = ConstructionItem(
            title = "Beton Kesme ve Delme (Karot)",
            imageResource = R.drawable.construction_item_karot,
        )

        // Çatı İşleri

        val kompleCati = ConstructionItem(
            title = "Komple Çatı İmalatı",
            imageResource = R.drawable.construction_item_komple_cati_imalati
        )
        val baca = ConstructionItem(
            title = "Baca",
            imageResource = R.drawable.construction_item_baca
        )

        // Cephe İşleri

        val cepheKaplamaSistemi = ConstructionItem(
            title = "Cephe Kaplama",
            imageResource = R.drawable.construction_item_cephe_kaplama,
            subCategories = listOf(
                ConstructionItem(title = "Prekast Cephe Kaplaması Yapılması"),
                ConstructionItem(title = "Sinterflex Cephe Kaplaması Yapılması"),
                ConstructionItem(title = "Kompozit Cephe Kaplaması Yapılması"),
                ConstructionItem(title = "Sıva, Boya Cephe Kaplaması Yapılması")
            )
        )
        val cepheIskele = ConstructionItem(
            title = "Cephe İskele",
            imageResource = R.drawable.construction_item_iskele
        )

        // Mekanik Tesisat İşleri

        val sihhiTesisatIsleri = ConstructionItem(
            title = "Sıhhi Tesisat İşleri",
            imageResource = R.drawable.construction_item_sihhi_tesisat_isleri,
            subCategories = listOf(
                ConstructionItem(title = "Daire Isıtma Sistemi"),
                ConstructionItem(title = "Sıcak Su Sistemi"),
                ConstructionItem(title = "Atık Su Sistemi"),
                ConstructionItem(title = "Yangın Söndürme Sistemi")
            )
        )
        val sogutmaKlimaSistemi = ConstructionItem(
            title = "Soğutma ve Klima Sistemi",
            imageResource = R.drawable.construction_item_sogutma_klima_sistemi,
        )
        val havalandirmaSistemi = ConstructionItem(
            title = "Havalandırma Sistemi",
            imageResource = R.drawable.construction_item_havalandirma_sistemi,
        )
        val mekanikMontaj = ConstructionItem(
            title = "Montaj",
            imageResource = R.drawable.construction_item_montaj,
        )
        val asansor = ConstructionItem(
            title = "Asansör",
            imageResource = R.drawable.construction_item_asansor,
        )

        //Elektrik Tesisat İşleri

        val gucDagitimSistemi = ConstructionItem(
            title = "Güç Dagitim Sistemi",
            imageResource = R.drawable.construction_item_guc_dagitim_sistemi,
        )
        val aydinlatmaIsiklandirmaSistemi = ConstructionItem(
            title = "Aydınlatma Işıklandırma Sistemi",
            imageResource = R.drawable.construction_item_aydinlatma_ve_isiklandirma_sistemi,
        )
        val iletisimSistemi = ConstructionItem(
            title = "İletişim Sistemi",
            imageResource = R.drawable.construction_item_iletisim_sistemi,
            subCategories = listOf(
                ConstructionItem(title = "Diyafon Sistemi"),
                ConstructionItem(title = "Akıllı Ev Sistemi")
            )
        )
        val guvenlikSistemi = ConstructionItem(
            title = "Güvenlik Sistemi",
            imageResource = R.drawable.construction_item_guvenlik_sistemi,
        )
        val yedekGucSistemi = ConstructionItem(
            title = "Yedek Güç Sistemi",
            imageResource = R.drawable.construction_item_yedek_guc_sistemi,
        )

        //İç İmalatlar

        val siva = ConstructionItem(
            title = "Siva",
            imageResource = R.drawable.construction_item_siva,
        )
        val boyaBadana = ConstructionItem(
            title = "Boya ve Badana",
            imageResource = R.drawable.construction_item_boya_badana
        )
        val icMekanIzolasyon = ConstructionItem(
            title = "İç Mekan İzolasyon",
            imageResource = R.drawable.construction_item_ic_mekan_izolasyon,
        )
        val alcipanKartonpiyer = ConstructionItem(
            title = "Alcipan ve Kartonpiyer",
            imageResource = R.drawable.construction_item_alcipan_kartonpiyer,
        )
        val sap = ConstructionItem(
            title = "Şap",
            imageResource = R.drawable.construction_item_sap,
        )
        val metalKorkuluk = ConstructionItem(
            title = "Metal Korkuluk",
            imageResource = R.drawable.construction_item_metal_korkuluk,
        )
        val mermer = ConstructionItem(
            title = "Mermer",
            imageResource = R.drawable.construction_item_mermer,
        )
        val seramik = ConstructionItem(
            title = "Seramik",
            imageResource = R.drawable.construction_item_seramik,
        )
        val parke = ConstructionItem(
            title = "Parke",
            imageResource = R.drawable.construction_item_parke,
        )
        val kapiPencereBalkon = ConstructionItem(
            title = "Kapı, Pencere ve Balkon",
            imageResource = R.drawable.construction_item_kapi_pencere_balkon,
        )
        val mutfak = ConstructionItem(
            title = "Mutfak",
            imageResource = R.drawable.construction_item_mutfak,
        )

        //Peysaj

        val bahce = ConstructionItem(
            title = "Bahce İşleri",
            imageResource = R.drawable.construction_item_bahce,
        )

        fun createCategories(): List<ConstructionItem> {

            val kazi = ConstructionItem(
                id = 0,
                title = "Kazi İşleri",
                imageResource = R.drawable.construction_item_kazi,
                subCategories = listOf(
                    iksaIsleri,
                    hafriyatIsleri
                )
            )
            val kabaYapi = ConstructionItem(
                id = 1,
                title = "Kaba Yapi İşleri",
                imageResource = R.drawable.construction_item_kaba_yapi,
                subCategories = listOf(
                    beton,
                    demir,
                    kalip,
                    betonDemirKalip,
                    duvar,
                    izolasyon,
                    digerKabaInsaatMalzeme,
                    betonKesmeDelme
                )
            )
            val cati = ConstructionItem(
                id = 2,
                title = "Çatı İşleri",
                imageResource = R.drawable.construction_item_cati,
                subCategories = listOf(
                    kompleCati,
                    baca
                )
            )
            val cephe = ConstructionItem(
                id = 3,
                title = "Cephe İşleri",
                imageResource = R.drawable.construction_item_cephe,
                subCategories = listOf(
                    cepheKaplamaSistemi,
                    cepheIskele
                )
            )
            val mekanikTesisat = ConstructionItem(
                id = 4,
                title = "Mekanik Tesisat İşleri",
                imageResource = R.drawable.construction_item_mekanik_tesisat,
                subCategories = listOf(
                    sihhiTesisatIsleri,
                    sogutmaKlimaSistemi,
                    havalandirmaSistemi,
                    mekanikMontaj,
                    asansor
                )
            )
            val elektrikTesisat = ConstructionItem(
                id = 5,
                title = "Elektrik Tesisat İşleri",
                imageResource = R.drawable.construction_item_elektrik_tesisat,
                subCategories = listOf(
                    gucDagitimSistemi,
                    aydinlatmaIsiklandirmaSistemi,
                    iletisimSistemi,
                    guvenlikSistemi,
                    yedekGucSistemi
                )
            )
            val icImalatlar = ConstructionItem(
                id = 6,
                title = "İç İmalatlar",
                imageResource = R.drawable.construction_item_ic_imalatlar,
                subCategories = listOf(
                    siva,
                    boyaBadana,
                    icMekanIzolasyon,
                    alcipanKartonpiyer,
                    sap,
                    metalKorkuluk,
                    mermer,
                    seramik,
                    parke,
                    kapiPencereBalkon,
                    mutfak
                )
            )
            val peysajVeCevre = ConstructionItem(
                id = 7,
                title = "Peysaj ve Çevre Düzenlemesi İşleri",
                imageResource = R.drawable.construction_item_peysaj_ve_cevre,
                subCategories = listOf(
                    bahce
                )
            )

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


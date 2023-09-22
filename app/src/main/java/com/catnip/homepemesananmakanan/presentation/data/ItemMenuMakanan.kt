package com.catnip.homepemesananmakanan.presentation.data

import com.catnip.homepemesananmakanan.presentation.model.Item

interface ItemMenuMakanan{

    fun getMenus(): List<Item>

}


class ItemMenuMakananImpl(): ItemMenuMakanan{

    override fun getMenus(): List<Item>{
        return mutableListOf(
            Item(
                position = 1,
                name = "Ayam Bakar",
                imgUrl = "https://github.com/Bahrulilmi30/project-chapter2/blob/master/assets/ic_ayam_bakar.png?raw=true",
                harga = "Rp 50.000",
                desc = "Ayam bakar adalah makanan enak dan lezat"
            ),
            Item(
                position = 2,
                name = "Ayam Goreng",
                imgUrl = "https://github.com/Bahrulilmi30/project-chapter2/blob/master/assets/ic_ayam_goreng.png?raw=true",
                harga = "Rp 40.000",
                desc = "Ayam goreng adalah makanan enak"
            ),
            Item(
                position = 3,
                name = "Ayam Geprek",
                imgUrl = "https://github.com/Bahrulilmi30/project-chapter2/blob/master/assets/ic_ayam_geprek.png?raw=true",
                harga = "Rp 40.000",
                desc = "ayam geprek adalah makanan pedas"
            ),
            Item(
                position = 4,
                name = "Sate Usus",
                imgUrl = "https://github.com/Bahrulilmi30/project-chapter2/blob/master/assets/ic_sate_usus.png?raw=true",
                harga = "Rp 5.000",
                desc = "sate usus terbuat dari usus ayam"
            ),
        )
    }
}
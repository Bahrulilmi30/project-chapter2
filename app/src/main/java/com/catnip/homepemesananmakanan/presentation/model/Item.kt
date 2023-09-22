package com.catnip.homepemesananmakanan.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import okhttp3.HttpUrl
import java.util.UUID

@Parcelize
data class Item(
    val id : String =UUID.randomUUID().toString(),
    val position : Int,
    val name : String,
    val imgUrl : String,
    val harga : String,
    val desc : String


    ): Parcelable {
    val locationUrlFood="https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
}

package com.siedg.coopercardmobile_android.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.net.URL

data class CardsListResult(val cards: List<Card>)

@Parcelize
data class Card(
    val name: String,
    val card_number: String,
    val limit: Float,
    val category: Category
) : Parcelable

@Parcelize
data class Category(
    val type: String,
    val background_color: String,
    val image_path: URL
) : Parcelable
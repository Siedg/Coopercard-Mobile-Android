package com.siedg.coopercardmobile_android.data

import android.graphics.Color
import java.net.URL

data class CardsListResult(val cards: List<Card>)

data class Card(
    val name: String,
    val card_number: String,
    val limit: Float,
    val category: Category
)

data class Category(
    val type: String,
    val background_color: String,
    val image_path: URL
)
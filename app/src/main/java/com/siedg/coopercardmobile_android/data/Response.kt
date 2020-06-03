package com.siedg.coopercardmobile_android.data

import android.graphics.Color
import java.net.URL

data class CardsListResult(val items: List<Card>)

data class Card(
    val name: String,
    val cardNumber: Int,
    val limit: Float,
    val category: Category
)

data class Category(
    val type: String,
    val backgroundColor: Color,
    val imagePath: URL
)
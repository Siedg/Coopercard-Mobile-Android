package com.siedg.coopercardmobile_android.ui

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.siedg.coopercardmobile_android.R
import com.siedg.coopercardmobile_android.data.Card
import kotlinx.android.synthetic.main.details_layout.*
import kotlinx.android.synthetic.main.details_layout.cardImage
import kotlinx.android.synthetic.main.details_layout.cardName

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_layout)
        setSupportActionBar(toolbarDetails)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val card = intent.getParcelableExtra<Card>("cardList")

        Glide.with(cardImage)
            .load(card?.category?.image_path)
            .into(cardImage)

        cardName.text = card!!.name
        lastDigits.text = getString(R.string.lastDigits, card.card_number)
        cardLimit.setTextColor(Color.parseColor(card.category.background_color))

        if (card.category.type == "gift") {
            cardLimit.text = getString(R.string.cardBalance)
        } else {
            cardLimit.text = getString(R.string.cardLimit, card.limit)
        }
    }
}

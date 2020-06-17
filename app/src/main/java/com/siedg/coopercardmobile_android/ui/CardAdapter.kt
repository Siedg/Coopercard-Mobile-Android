package com.siedg.coopercardmobile_android.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.siedg.coopercardmobile_android.R
import com.siedg.coopercardmobile_android.data.Card
import kotlinx.android.synthetic.main.cardlist_layout.view.*


class CardAdapter(val context: Context) : RecyclerView.Adapter<CardAdapter.CustomViewHolder>() {
    private val items: MutableList<Card> = mutableListOf()

    class CustomViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        fun bind(card: Card) {
            itemView.apply {
                cardName.text = card.name
                cardNumber.text = context.getString(R.string.cardNumber, card.card_number)
                limitAmount.text = context.getString(R.string.limitAmount, card.limit)
                cardNumber.setTextColor(Color.parseColor(card.category.background_color))
                view.setBackgroundColor(Color.parseColor(card.category.background_color))

                Glide.with(cardImage)
                    .load(card.category.image_path)
                    .into(cardImage)

                if (card.category.type == "gift") {
                    limitText.text = context.getString(R.string.balance)
                }

                setOnClickListener{

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardlist_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateList(collection: Collection<Card>) {
        items.clear()
        items.addAll(collection)
        notifyDataSetChanged()
    }


}

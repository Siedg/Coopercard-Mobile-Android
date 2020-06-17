package com.siedg.coopercardmobile_android.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.siedg.coopercardmobile_android.R
import com.siedg.coopercardmobile_android.data.Card
import kotlinx.android.synthetic.main.cardlist_layout.view.*


class CardAdapter(val context: Context) : RecyclerView.Adapter<CardAdapter.CustomViewHolder>() {
    private val items: MutableList<Card> = mutableListOf()

    class CustomViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        fun bind(card: Card) {
            itemView.apply {
                cardName.text = card.name
                cardNumber.text = card.card_number.toString()
                limitAmount.text = context.getString(R.string.limitAmount, card.limit)
                cardNumber.setBackgroundColor(Color.parseColor(card.category.background_color))

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

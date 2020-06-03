package com.siedg.coopercardmobile_android.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.siedg.coopercardmobile_android.R
import com.siedg.coopercardmobile_android.data.Card
import com.siedg.coopercardmobile_android.data.CardsListResult



class cardsAdapter(val cardList: CardsListResult, val context: Context) : BaseAdapter() {


    private class ViewHolder(row: View?) {
        val cardName: TextView
        val cardNumber: TextView
        val cardLimit: TextView
        val cardImage: ImageView

        init {
            this.cardName = row?.findViewById(R.id.cardName) as TextView
            this.cardNumber = row?.findViewById(R.id.cardNumber) as TextView
            this.cardLimit = row?.findViewById(R.id.cardLimit) as TextView
            this.cardImage = row?.findViewById(R.id.cardImage) as ImageView
        }
    }


    override fun getCount(): Int {
        return cardList.items.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return cardList.items.get(position)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.card_item_list, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var card: Card = getItem(position) as Card
        viewHolder.cardName.text = card.name
        viewHolder.cardNumber.text = card.cardNumber.toString()
        viewHolder.cardLimit.text = card.limit.toString()
        //viewHolder.cardImage.setImageResource(card.category.imagePath)


        return view as View
    }


    //class ViewHolder(val textView:TextView) : RecyclerView.ViewHolder(textView)


}

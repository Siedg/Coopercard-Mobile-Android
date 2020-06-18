package com.siedg.coopercardmobile_android.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siedg.coopercardmobile_android.R
import com.siedg.coopercardmobile_android.data.Card
import com.siedg.coopercardmobile_android.data.Request
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbarCooperCard)
        doAsync{
            val result = Request.run()
            uiThread {
                (cardList.adapter as CardAdapter).updateList(result.cards)
            }
        }

        cardList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = CardAdapter(context, ::onCardClick)
        }

        addCardButton.setOnClickListener {
            //TODO
        }
    }

    private fun onCardClick(card: Card) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("cardList", card)
        startActivity(intent)
    }

    /*
    private fun isNetworkConnected(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
    */
}
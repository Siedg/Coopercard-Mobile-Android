package com.siedg.coopercardmobile_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.siedg.coopercardmobile_android.R
import com.siedg.coopercardmobile_android.data.Request
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doAsync{
            val result = Request.run()
            uiThread {
                Log.d("Debug", "¨$result")
                (cardList.adapter as CardAdapter).updateList(result.cards)
            }
        }

        val trashIcon = R.drawable.ic_trash
        val padlockIcon = R.drawable.ic_padlock
        val editIcon = R.drawable.ic_edit


        val layoutManager = LinearLayoutManager(this)
        cardList.apply {
            setLayoutManager(layoutManager)
            adapter = CardAdapter(context)
        }

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
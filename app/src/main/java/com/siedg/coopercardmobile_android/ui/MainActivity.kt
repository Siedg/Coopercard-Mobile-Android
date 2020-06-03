package com.siedg.coopercardmobile_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.siedg.coopercardmobile_android.R
import com.siedg.coopercardmobile_android.data.Request
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://raw.githubusercontent.com/policante/Coopercard-mobile/master/service/cards.json"
        doAsync{
            val result = Request().run()
            uiThread { longToast("Made request")}
        }

        val recyclerView = findViewById<RecyclerView>(R.id.cardsList).apply {
            //val layoutManager = RecyclerView.LayoutManager
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
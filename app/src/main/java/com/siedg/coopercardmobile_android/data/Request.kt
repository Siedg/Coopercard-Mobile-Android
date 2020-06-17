package com.siedg.coopercardmobile_android.data

import com.google.gson.Gson
import java.net.URL

class Request {
    companion object {
        fun run(): CardsListResult {
            val cardListJson =
                URL("https://raw.githubusercontent.com/policante/Coopercard-mobile/master/service/cards.json").readText()
            //Log.d("Result", cardListJson)
            return Gson().fromJson(cardListJson, CardsListResult::class.java)
        }
    }
}
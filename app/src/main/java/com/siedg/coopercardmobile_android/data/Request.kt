package com.siedg.coopercardmobile_android.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL

class Request {
    fun run(): CardsListResult {
        val cardsRepoListJson = URL("https://raw.githubusercontent.com/policante/Coopercard-mobile/master/service/cards.json").readText()
        Log.d(javaClass.simpleName, cardsRepoListJson)
        return Gson().fromJson(cardsRepoListJson, CardsListResult::class.java)
    }
}
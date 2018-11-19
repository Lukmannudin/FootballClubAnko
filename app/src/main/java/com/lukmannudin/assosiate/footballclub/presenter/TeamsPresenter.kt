package com.lukmannudin.assosiate.footballclub.presenter

import com.google.gson.Gson
import com.lukmannudin.assosiate.footballclub.ApiRepository
import com.lukmannudin.assosiate.footballclub.TeamResponse
import com.lukmannudin.assosiate.footballclub.TeamsView
import com.lukmannudin.assosiate.footballclub.TheSportDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson){
    fun getTeamList(league: String?){
        view.showLoading()
        doAsync {
           val data = gson.fromJson(apiRepository
               .doRequest(TheSportDBApi.getTeams(league)),
               TeamResponse::class.java
           )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)

            }
        }
    }
}


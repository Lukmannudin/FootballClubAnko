package com.lukmannudin.assosiate.footballclub.presenter

import android.util.Log
import com.google.gson.Gson
import com.lukmannudin.assosiate.footballclub.ApiRepository
import com.lukmannudin.assosiate.footballclub.TeamDetailView
import com.lukmannudin.assosiate.footballclub.TeamResponse
import com.lukmannudin.assosiate.footballclub.TheSportDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(  private val view: TeamDetailView,
                             private val apiRepository: ApiRepository,
                             private val gson: Gson) {
    fun getTeamDetail(teamId: String){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeamDetail(teamId)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                Log.i("CEKTEAM",data.teams[0].teamName)
                view.showDetailTeam(data.teams)
            }
        }
    }
}
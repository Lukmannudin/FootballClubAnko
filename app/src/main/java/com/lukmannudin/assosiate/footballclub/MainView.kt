package com.lukmannudin.assosiate.footballclub

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}
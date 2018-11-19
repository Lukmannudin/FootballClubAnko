package com.lukmannudin.assosiate.footballclub

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showDetailTeam(data: List<Team>)
}
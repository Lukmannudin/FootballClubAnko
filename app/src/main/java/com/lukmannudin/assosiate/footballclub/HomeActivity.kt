package com.lukmannudin.assosiate.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lukmannudin.assosiate.footballclub.Fragment.FavoriteTeamsFragment
import com.lukmannudin.assosiate.footballclub.Fragment.TeamsFragment
import com.lukmannudin.assosiate.footballclub.R.id.favorites
import com.lukmannudin.assosiate.footballclub.R.id.teams
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottom_navigation.setOnNavigationItemSelectedListener {item ->
            when (item.itemId){
                teams -> {
                    loadTeamsFragment(savedInstanceState)
                }

                favorites -> {
                    loadFavoritesFragment(savedInstanceState)
                }

            }
        true
        }
        bottom_navigation.selectedItemId = teams
    }

    private fun loadTeamsFragment(savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, FavoriteTeamsFragment(), FavoriteTeamsFragment::class.java.simpleName)
                .commit()
        }
    }
}

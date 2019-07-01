package com.kimyasin.movieapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, About.OnFragmentInteractionListener,
        Share.OnFragmentInteractionListener, Settings.OnFragmentInteractionListener

{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the home action
               supportFragmentManager.beginTransaction().replace(R.id.relativelayout,
                   Home()).commit()
            }

            R.id.nav_movies -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativelayout,
                    Movies()).commit()

            }

            R.id.nav_settings -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativelayout,
                    Settings()).commit()
            }
            R.id.nav_subscribe -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativelayout,
                    Subscribe()).commit()
            }

            R.id.nav_share -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativelayout,
                    Share()).commit()
            }
            R.id.nav_about -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativelayout,
                    About()).commit()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

   override fun onFragmentInteraction(uri: Uri) {
        Log.d("Electronic Armony", "On Fragment  Interaction")
    }
}

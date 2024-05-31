package com.universae.memy

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Asignamos a una variable la referencia al layout de la toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
         val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        as NavHostFragment

        //Asignamos a una variable la referencia al layout del navigation drawer
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        val navController = navHostFragment.navController
        //Configuramos la toolbar para aparecer en estos fragmentos y le indicamos que aparezca
        // el icono de menú lateral en la toolbar
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.agendaFragment,
            R.id.notesFragment,
            R.id.mainCalendarFragment,
            R.id.tasksFragment
        ).setOpenableLayout(drawer).build()

        toolbar.setupWithNavController(navController, appBarConfiguration)
        //Creamos el vínculo entre el controlador de navegación y el menú lateral
        val navView = findViewById<NavigationView>(R.id.nav_view)
        NavigationUI.setupWithNavController(navView, navController)

        //Creamos el vínculo entre el controlador de navegación y el menú inferior
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavView.setupWithNavController(navController)


        }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)

    }
}
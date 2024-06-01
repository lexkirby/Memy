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

        /*Asignamos a una variable la referencia al layout de la toolbar */
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)

        /*Establecemos la toolbar como la barra de menú superior que habrá para la aplicación */
        setSupportActionBar(toolbar)

        /*Recogemos en una variable el NavHostFragment del layout, el cual actúa como contenedor de
        los fragmentos durante la navegación */
         val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        as NavHostFragment

        /*Asignamos a una variable la referencia al layout del menú lateral */
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        /*Recogemos en una variable el controlador de navegación que hay en el NavHostFragment
        del layout */
        val navController = navHostFragment.navController

        /*Creamos un objeto AppBarConfiguration configurándolo para reconocer estos
        fragmentos como top-level destinations y que así en el fragmento de Ajustes en la toolbar
        aparezca una flecha para volver atrás */
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.agendaFragment,
            R.id.notesFragment,
            R.id.mainCalendarFragment,
            R.id.tasksFragment
        ).setOpenableLayout(drawer).build() /*setOpenableLayout establece que el menú lateral se
         pueda abrir o cerrar por la navegación */

        /*Unimos la toolbar con el controlador de navegación y la configuración de la toolbar para
         que cuando se navegue a diferentes fragmentos se muestre el nombre del fragmento en el que
         nos encontremos*/
        toolbar.setupWithNavController(navController, appBarConfiguration)

        /*Creamos el vínculo entre el controlador de navegación y el menú lateral*/
        val navView = findViewById<NavigationView>(R.id.nav_view)
        NavigationUI.setupWithNavController(navView, navController)

        /*Creamos el vínculo entre el controlador de navegación y la barra de menú inferior*/
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavView.setupWithNavController(navController)


        }

    /*Creamos un método que añada los items del recurso de la toolbar a la toolbar */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    /*Creamos un método para que al clicar en un item de la toolbar se navegue a su correspondiente
     fragmento */
    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)

    }
}
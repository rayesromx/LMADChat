package com.fcfm.poi.plantilla

import android.os.Bundle
import android.view.KeyboardShortcutGroup
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.SupportActionModeWrapper
import androidx.fragment.app.Fragment
import com.fcfm.poi.plantilla.fragments.FragmentAlerts
import com.fcfm.poi.plantilla.fragments.FragmentChat
import com.fcfm.poi.plantilla.fragments.FragmentGroupChat
import com.fcfm.poi.plantilla.fragments.FragmentTask
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)
        MyToolbar().show(this, "Alertas", false) //checar con el profe

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> changeFragment(FragmentAlerts(), "fragmentAlerts")
                    1 -> {
                        changeFragment(FragmentChat(), "fragmentChat")
                    }
                    2 -> {
                        changeFragment(FragmentGroupChat(), "fragmentGroupChat")
                    }
                    3 -> {
                        changeFragment(FragmentTask(), "fragmentTasks")
                    }
                    else -> changeFragment(FragmentAlerts(), "fragmentAlerts")
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        // Pestana que estara seleccionada por default al abrir el activity
        tabLayout.selectTab(tabLayout.getTabAt(0))
        changeFragment(FragmentChat(), "fragmentAlerts")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.id_group)
            Toast.makeText(this, "Abriste Grupos", Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }

    fun changeFragment(fragment: Fragment, tag: String) {

        val currentFragment = supportFragmentManager.findFragmentByTag(tag)

        // Se valida que no este ya puesto el fragmento en el contenedor
        if (currentFragment == null || currentFragment.isVisible.not()) {

            // Se cambia el fragmento actual en el contenedor por el nuevo fragmento
            supportFragmentManager.beginTransaction()
                .replace(R.id.framentContainer, fragment, tag)
                .commit()
        }
    }
}
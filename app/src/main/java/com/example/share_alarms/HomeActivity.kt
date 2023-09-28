package com.example.share_alarms
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.share_alarms.databinding.HomeBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class HomeActivity : AppCompatActivity() {
     lateinit var binding:HomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Carga el fragmento ListadoFragment en el contenedor al iniciar
        loadFragment(ListadoFragment())

        binding.bottomNavMenu.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Reemplaza el fragmento actual con ListadoFragment
                    loadFragment(ListadoFragment())
                    true
                }
                R.id.navigation_contactos -> {
                    loadFragment(ContactoFragment())
                    true
                }
                R.id.navigation_notifications -> {
                    loadFragment(NotificacionFragment())
                    true
                }
                else -> false
            }
        }

        // navegacion barra de menú superior
        val topAppBar = findViewById<Toolbar>(R.id.topAppBar)
        topAppBar.overflowIcon = ContextCompat.getDrawable(this, R.drawable.perfil_icon)
        setSupportActionBar(topAppBar)

        topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_perfil -> {
                Toast.makeText(this, "Ir al perfil del usuario", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}


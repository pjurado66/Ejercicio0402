package com.pjurado.ejercicio0402

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {
    companion object{
        private lateinit var contactoSeleccionado: Contacto
        var FRAGMENT: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        when(resources.configuration.orientation){
            Configuration.ORIENTATION_PORTRAIT -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PrimerFragment())
                    .commit()
            }
            Configuration.ORIENTATION_LANDSCAPE -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PrimerFragment())
                    .commit()
                if (FRAGMENT == 1){
                    val fragment = DetailFragment()
                    fragment.arguments = bundleOf(DetailFragment.CONTACTO to contactoSeleccionado)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.detalle, fragment)
                        .commit()
                }
/*                else{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.detalle, fragment)
                        .commit()
                }*/

            }
        }
    }

    fun cargaDetailFragment(contacto: Contacto){
        val fragment = DetailFragment()
        contactoSeleccionado = contacto
        FRAGMENT = 1
        fragment.arguments = bundleOf(DetailFragment.CONTACTO to contacto)
        when(resources.configuration.orientation){
            Configuration.ORIENTATION_PORTRAIT -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null)
                    .commit()
            }
            Configuration.ORIENTATION_LANDSCAPE -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.detalle, fragment)
                    .commit()
            }
        }
    }
}
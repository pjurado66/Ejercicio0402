package com.pjurado.ejercicio0402

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        when(resources.configuration.orientation){
            Configuration.ORIENTATION_PORTRAIT -> {}
            Configuration.ORIENTATION_LANDSCAPE -> {}
        }
    }

    fun cargaDetailFragment(contacto: Contacto){
        val fragment = DetailFragment()
        fragment.arguments = bundleOf(DetailFragment.CONTACTO to contacto)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
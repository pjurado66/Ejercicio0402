package com.pjurado.ejercicio0402

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.pjurado.ejercicio0402.databinding.FragmentDetailBinding


class DetailFragment(val llamar: (String?) -> Unit, val email: (String?) -> Unit) : Fragment(R.layout.fragment_detail) {

    companion object {
        const val CONTACTO = "contacto"
        const val LLAMAR = "llamar"
        const val EMAIL = "email"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view).apply {
            val contacto = arguments?.getParcelable<Contacto>(CONTACTO).let { contacto ->
                nombre.text = contacto?.nombre
                Glide.with(imagen)
                    .load(contacto?.foto)
                    .into(imagen)
                email.setOnClickListener {
                    email(contacto?.telefono)
                }
                telefono.setOnClickListener {
                    llamar(contacto?.email)
                }
            }
        }

    }


}
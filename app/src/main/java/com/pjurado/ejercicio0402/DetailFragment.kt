package com.pjurado.ejercicio0402

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.pjurado.ejercicio0402.databinding.FragmentDetailBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {

    companion object {
        const val CONTACTO = "contacto"
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
                    mandaEmail(contacto?.email)
                }
                telefono.setOnClickListener {
                    llamaTelefono(contacto?.telefono)
                }
            }
        }

    }

    private fun llamaTelefono(telefono: String?) {
        TODO("Not yet implemented")
    }

    private fun mandaEmail(email: String?) {
        TODO("Not yet implemented")
    }
}
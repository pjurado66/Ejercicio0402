package com.pjurado.ejercicio0402

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.pjurado.ejercicio0402.databinding.FragmentPrimerBinding


class PrimerFragment : Fragment(R.layout.fragment_primer) {
    private lateinit var listener: MainActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPrimerBinding.bind(view).apply {
            recyclerView.adapter = ContactosAdapter(contactos, listener)
        }
    }

    private val contactos = (1..100).map {
        Contacto(
            "Nombre $it",
            "954$it$it$it$it$it$it$it",
            "nombre$it@gmail.com",
            "https://picsum.photos/200/300?random=$it"
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity){
            listener = context
        }
    }
}
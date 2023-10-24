package com.pjurado.ejercicio0402

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pjurado.ejercicio0402.databinding.ViewContactoBinding

class ContactosAdapter(val contactos: List<Contacto>, val listener: MainActivity) : RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ViewContactoBinding.bind(view)

        fun bind(contacto: Contacto){
            with(binding){
                nombre.text = contacto.nombre
                email.text = contacto.email
                telefono.text = contacto.telefono

                Glide.with(imagen)
                    .load(contacto.foto)
                    .into(imagen)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactosAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_contacto, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = contactos.size

    override fun onBindViewHolder(holder: ContactosAdapter.ViewHolder, position: Int) {
        holder.bind(contactos[position])
        holder.itemView.setOnClickListener { listener.cargaDetailFragment(contactos[position]) }
    }

}

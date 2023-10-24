package com.pjurado.ejercicio0402

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contacto(
    val nombre: String,
    val telefono: String,
    val email: String,
    val foto: String
): Parcelable

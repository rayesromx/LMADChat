package com.fcfm.poi.plantilla.models

//import com.google.firebase.database.Exclude

data class Mensaje(
    var id: String = "",
    var contenido: String = "",
    var de: String = "",
    val timeStamp: Any? = null,
    var esMio: Boolean = true
)

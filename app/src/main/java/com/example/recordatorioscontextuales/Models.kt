package com.example.recordatorioscontextuales

import android.R
import java.time.LocalDateTime

//Categorias posibles de un recordatorio
sealed class Categoria(val etiqueta:String){
    object Personal : Categoria("Personal")
    object Trabajo : Categoria("Trabajo")
    object Salud : Categoria("Salud")
    object Estudios : Categoria("Estudios")
}

//Prioridades disponibles
sealed class Prioridad(val etiqueta: String, val nivel: Int){
    object Baja : Prioridad("Baja",1)
    object Media : Prioridad("Media",2)
    object  Alta : Prioridad("Alta",3)
}

//Estados de un recordatorio
sealed class EstadoRecordatorio (val etiqueta: String){
    object Pendiente : EstadoRecordatorio("Pendiente")
    object EnCurso : EstadoRecordatorio("En curso")
    object Completado : EstadoRecordatorio("Completado")
}

//estados generales de la aplicacion
sealed class EstadoAplicacion{
    object Cargando : EstadoAplicacion()
    object  Lista : EstadoAplicacion()
    data class Error (val mensaje: String): EstadoAplicacion()
}

//Ubicacion opcional del recordatorio
data class Ubicacion (
    val latitud: Double,
    val longitud: Double,
    val descripcion: String? = null
)

//Modelo principal
data class Recordatorio (
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val categoria: Categoria,
    val prioridad: Prioridad,
    val estado: EstadoRecordatorio,
    val fechaVencimiento: LocalDateTime? = null,
    val ubicacion: Ubicacion? = null,
    val aviso: LocalDateTime? = null,
    val sincronizado: Boolean = false
)
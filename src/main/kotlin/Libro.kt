package org.pebiblioteca

import UtilidadesBiblioteca

class Libro(
    val titulo:String,
    val autor:String,
    val fechaDePublicacion:Int,
    val tematica:String,
    var estado:Estado = Estado.DISPONIBLE,
    val id:String = UtilidadesBiblioteca().generarIdentificadorUnico()
) {
    init {
        require(titulo.isNotBlank()){ "El título no puede estar vacio"}
        require(autor.isNotBlank()){ "El autor no puede estar vacio"}
    }
}
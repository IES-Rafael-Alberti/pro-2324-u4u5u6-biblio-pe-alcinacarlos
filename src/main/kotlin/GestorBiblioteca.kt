package org.pebiblioteca

class GestorBiblioteca(
    val catalogo: MutableList<Libro> = mutableListOf(),
    val registroPrestamos:MutableMap<Libro, Estado> = mutableMapOf()
) {
    fun agregarLibro(){

    }
    fun eliminarLibro(){

    }
    fun registrarPrestamo(){

    }
    fun devolverLibro(){

    }
}
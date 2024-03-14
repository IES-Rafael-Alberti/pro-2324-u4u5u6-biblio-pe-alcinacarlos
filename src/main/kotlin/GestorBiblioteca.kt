package org.pebiblioteca

import RegistroPrestamos
import Usuario

class GestorBiblioteca(
    private val catalogo: MutableList<Libro> = mutableListOf(),
    private val registroPrestamos:RegistroPrestamos = RegistroPrestamos()
) {
    fun agregarLibro(libro: Libro){
        catalogo.add(libro)
    }
    fun eliminarLibro(libro: Libro){
        catalogo.remove(libro)
    }
    fun registrarPrestamo(libro: Libro, usuario: Usuario){
        if (consultarDisponibilidad(libro)) libro.estado = Estado.PRESTADO
        else println("Libro ya prestado")
        registroPrestamos.registrarPrestamo(usuario, libro)
    }
    fun devolverLibro(libro: Libro, usuario: Usuario){
        if (!consultarDisponibilidad(libro)) libro.estado = Estado.DISPONIBLE
        else println("Libro ya diponible")
        registroPrestamos.devolverPrestamo(usuario,libro)
    }
    fun consultarHistorialLibro(libro: Libro): MutableList<Usuario> {
        return registroPrestamos.consultarHistorialLibro(libro)
    }
    fun consultarHistorialUsuario(usuario: Usuario):List<MutableList<Libro>>{
        return registroPrestamos.consultarHistorialUsuario(usuario)
    }

    private fun consultarDisponibilidad(libro: Libro):Boolean{
        return libro.estado != Estado.PRESTADO
    }

    fun retornarEnFuncionEstado(estado: String): List<Libro> {
        return when(estado.lowercase()){
            "disponibles" -> {
                catalogo.filter { it.estado == Estado.DISPONIBLE }
            }
            "prestados" -> catalogo.filter { it.estado == Estado.PRESTADO }
            else -> {
                catalogo
            }
        }
    }

}
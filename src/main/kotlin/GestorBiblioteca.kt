package org.pebiblioteca

class GestorBiblioteca(
    val catalogo: MutableList<Libro> = mutableListOf(),
    val registroPrestamos:MutableMap<Libro, Estado> = mutableMapOf()
) {
    fun agregarLibro(libro: Libro){
        catalogo.add(libro)
    }
    fun eliminarLibro(libro: Libro){
        catalogo.remove(libro)
    }
    fun registrarPrestamo(libro: Libro){
        if (consultarDisponibilidad(libro)) libro.estado = Estado.PRESTADO
        else println("Libro ya prestado")
        registroPrestamos[libro] = Estado.PRESTADO
    }
    fun devolverLibro(libro: Libro){
        if (!consultarDisponibilidad(libro)) libro.estado = Estado.DISPONIBLE
        else println("Libro ya diponible")
        registroPrestamos[libro] = Estado.DISPONIBLE
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
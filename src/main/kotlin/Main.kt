package org.pebiblioteca

fun main() {
    val gestorBiblioteca = GestorBiblioteca()
    val libros = mutableListOf(
        Libro("Lucas va por el mundo","Carlos Alcina", 2024, "Algo"),
        Libro("Ayuda","Carlos Alcina2", 2020, "Algo2"),
        Libro("Muy largo el examen","Carlos Alcina3", 2021, "Algo3")
    )
    for (libro in libros){
        gestorBiblioteca.agregarLibro(libro)
    }

    gestorBiblioteca.registrarPrestamo(libros[0])
    gestorBiblioteca.registrarPrestamo(libros[1])
    gestorBiblioteca.registrarPrestamo(libros[1])

    gestorBiblioteca.devolverLibro(libros[0])
    gestorBiblioteca.devolverLibro(libros[1])
    gestorBiblioteca.devolverLibro(libros[1])

    for (libro in gestorBiblioteca.retornarEnFuncionEstado("todo")){
        println(libro)
    }

    var salir = false
    while (!salir){
        Menu.mostrar()
        val respuesta = readln().trim()
        when(respuesta){
            "1" -> {
                gestorBiblioteca.agregarLibro(Menu.crearNuevoLibro())
                println("Libro agregado con exito")
                Menu.mostrar()
            }
            "2" -> {
                gestorBiblioteca.eliminarLibro(Menu.preguntarBuscarLibro(gestorBiblioteca.catalogo))
                println("Libro borrado con exito")
                Menu.mostrar()
            }
            "3" -> {
                gestorBiblioteca.registrarPrestamo(Menu.preguntarBuscarLibro(gestorBiblioteca.catalogo))
                println("Prestamo realiza con exito")
                Menu.mostrar()
            }
            "4" -> {
                gestorBiblioteca.devolverLibro(Menu.preguntarBuscarLibro(gestorBiblioteca.catalogo))
                println("Libro devuelto con exito")
                Menu.mostrar()
            }
            "5" -> {
                for (libro in gestorBiblioteca.retornarEnFuncionEstado(Menu.preguntarEstado())){
                    println(libro)
                }
            }
            "6" -> {
                println("Hasta luego!!!")
                salir = true
            }
            else -> println("Opción inválida")
        }
    }




}
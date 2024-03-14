package org.pebiblioteca

import Usuario

fun main() {
    val gestorBiblioteca = GestorBiblioteca()
    val libros = mutableListOf(
        Libro("Lucas va por el mundo","Carlos Alcina", 2024, "Algo"),
        Libro("Ayuda","Carlos Alcina2", 2020, "Algo2"),
        Libro("Muy largo el examen","Carlos Alcina3", 2021, "Algo3")
    )
    val usuario1 = Usuario("Lucas")
    for (libro in libros){
        gestorBiblioteca.agregarLibro(libro)
    }

    gestorBiblioteca.registrarPrestamo(libros[0], usuario1)
    gestorBiblioteca.registrarPrestamo(libros[1], usuario1)
    gestorBiblioteca.registrarPrestamo(libros[1], usuario1)

    gestorBiblioteca.devolverLibro(libros[0], usuario1)
    gestorBiblioteca.devolverLibro(libros[1], usuario1)
    gestorBiblioteca.registrarPrestamo(libros[1], usuario1)

    gestorBiblioteca.devolverLibro(libros[1], usuario1)

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
                gestorBiblioteca.eliminarLibro(Menu.preguntarBuscarLibro(gestorBiblioteca.retornarEnFuncionEstado("todos")))
                println("Libro borrado con exito")
                Menu.mostrar()
            }
            "3" -> {
                gestorBiblioteca.registrarPrestamo(Menu.preguntarBuscarLibro(gestorBiblioteca.retornarEnFuncionEstado("todos")), usuario1)
                println("Prestamo realiza con exito")
                Menu.mostrar()
            }
            "4" -> {
                gestorBiblioteca.devolverLibro(Menu.preguntarBuscarLibro(gestorBiblioteca.retornarEnFuncionEstado("todos")), usuario1)
                println("Libro devuelto con exito")
                Menu.mostrar()
            }
            "5" -> {
                for (libro in gestorBiblioteca.retornarEnFuncionEstado(Menu.preguntarEstado())){
                    println(libro)
                }
            }
            "6" -> {
               println(gestorBiblioteca.consultarHistorialLibro(Menu.preguntarBuscarLibro(gestorBiblioteca.retornarEnFuncionEstado("todos"))))
            }
            "7" -> {
                println(gestorBiblioteca.consultarHistorialUsuario(usuario1))
            }
            "8" -> {
                println("Hasta luego!!!")
                salir = true
            }
            else -> println("Opción inválida")
        }
    }




}
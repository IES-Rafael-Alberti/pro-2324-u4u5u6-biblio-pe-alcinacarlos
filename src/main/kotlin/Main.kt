fun main() {
    val catalogo = mutableListOf<ElementoBiblioteca>()
    val gestorPrestamos = RegistroPrestamos()
    val gestorBiblioteca1 = GestorBiblioteca(catalogo, gestorPrestamos)

    val elementosBiblioteca = mutableListOf(
        Libro("Lucas va por el mundo", "Carlos Alcina", 2024, "Algo"),
        Revista("Ayuda", "Carlos Alcina2", 2020, "Algo2"),
        Libro("Muy largo el examen", "Carlos Alcina3", 2021, "Algo3"),
        Revista("Salvame", "Carlitos", 2020, "hola diego")
    )
    val usuario1 = Usuario("Lucas")
    for (elementoBiblioteca in elementosBiblioteca){
        gestorBiblioteca1.agregarElementoBiblioteca(elementoBiblioteca)
    }

    gestorBiblioteca1.registrarPrestamo(elementosBiblioteca[0], usuario1)
    gestorBiblioteca1.registrarPrestamo(elementosBiblioteca[1], usuario1)
    gestorBiblioteca1.registrarPrestamo(elementosBiblioteca[1], usuario1)

    gestorBiblioteca1.devolverLibro(elementosBiblioteca[0], usuario1)
    gestorBiblioteca1.devolverLibro(elementosBiblioteca[1], usuario1)
    gestorBiblioteca1.registrarPrestamo(elementosBiblioteca[1], usuario1)

    gestorBiblioteca1.devolverLibro(elementosBiblioteca[1], usuario1)

    for (elementoBiblioteca in gestorBiblioteca1.retornarEnFuncionEstado("todo")){
        println(elementoBiblioteca)
    }
    var salir = false
    while (!salir){
        Menu.mostrar()
        val respuesta = readln().trim()
        when(respuesta){
            "1" -> {
                gestorBiblioteca1.agregarElementoBiblioteca(Menu.crearNuevoLibro())
                println("Libro agregado con exito")
                Menu.mostrar()
            }
            "2" -> {
                gestorBiblioteca1.eliminarElementoBiblioteca(Menu.preguntarBuscarElemento(gestorBiblioteca1.retornarEnFuncionEstado("todos")))
                println("Libro borrado con exito")
                Menu.mostrar()
            }
            "3" -> {
                gestorBiblioteca1.registrarPrestamo(
                    Menu.preguntarBuscarElemento(
                        gestorBiblioteca1.retornarEnFuncionEstado(
                            "todos"
                        )
                    ), usuario1)
                println("Prestamo realiza con exito")
                Menu.mostrar()
            }
            "4" -> {
                gestorBiblioteca1.devolverLibro(Menu.preguntarBuscarElemento(gestorBiblioteca1.retornarEnFuncionEstado("todos")), usuario1)
                println("Libro devuelto con exito")
                Menu.mostrar()
            }
            "5" -> {
                for (elementoBiblioteca in gestorBiblioteca1.retornarEnFuncionEstado(Menu.preguntarEstado())){
                    println(elementoBiblioteca)
                }
            }
            "6" -> {
                println(gestorBiblioteca1.consultarHistorialElementoBiblioteca(
                    Menu.preguntarBuscarElemento(
                        gestorBiblioteca1.retornarEnFuncionEstado(
                            "todos"
                        )
                    )
                ))
            }
            "7" -> {
                println(gestorBiblioteca1.consultarHistorialUsuario(usuario1))
            }
            "8" -> {
                println("Hasta luego!!!")
                salir = true
            }
            else -> println("Opción inválida")
        }
    }
}
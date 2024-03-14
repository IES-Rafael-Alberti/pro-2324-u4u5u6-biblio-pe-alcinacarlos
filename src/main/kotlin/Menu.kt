package org.pebiblioteca

object Menu {
    fun mostrar(){
        println("Bienvenido a la Bibloteca, qué desea hacer?")
        println("1 -> Añadir un libro")
        println("2 -> Eliminar un libro")
        println("3 -> Registrar un préstamo")
        println("4 -> Devolver un libro")
        println("5 -> Retornar los libros según su estado (todo, disponibles, prestados)")
        println("6 -> Salir")
    }
    private fun buscarLibroPorId(catalogo: MutableList<Libro>):Libro{
        var id: String
        var libro: Libro? = null
        while (libro == null){
            println("Dime una id de un libro que se encuentre en el catalogo: ")
            try {
                id = readln()
                libro = catalogo.find { it.id == id }
            }catch (e:NumberFormatException){
                println("ID no válida")
            }
        }
        return libro
    }
    private fun buscarLibroPorTitulo(catalogo: MutableList<Libro>):Libro{
        var titulo: String?
        var libro: Libro? = null
        while (libro == null){
            println("Dime el nombre de un libro que esté en el catalogo: ")
            titulo = readln()
            libro = catalogo.find { it.titulo == titulo }
        }
        return libro
    }
    fun preguntarBuscarLibro(catalogo: MutableList<Libro>):Libro{
        var libro:Libro? = null
        while (libro == null){
            println("Cómo quieres buscar el libro?")
            println("1 -> Por ID")
            println("2 -> Por titulo")
            libro = when(readln().trim()){
                "1" -> buscarLibroPorId(catalogo)
                "2" -> buscarLibroPorTitulo(catalogo)
                else -> {
                    println("Opción no válida")
                    null
                }
            }
        }
        return libro
    }
    fun preguntarEstado():String{
        val estado = arrayOf("disponibles", "todos", "prestados")
        var respuesta = ""
        while (respuesta !in estado){
            println("Introduce un estado (disponibles, todos, prestados): ")
            respuesta = readln().trim()
        }
        return respuesta
    }
    fun crearNuevoLibro():Libro{
        println("Qué título quieres que tenga el libro?")
        val titulo = readln().trim()

        println("Quién es el autor?")
        val autor = readln()

        var fechaDePublicacion:Int? = null
        while (fechaDePublicacion == null || fechaDePublicacion !in 1900..2024){
            println("Fecha de publicacion (entre 1900 y 2024): ")
            fechaDePublicacion = readln().toIntOrNull()
        }

        println("Tematica del libro:")
        val tematica = readln()


        return Libro(titulo, autor, fechaDePublicacion, tematica)
    }
}
object Menu {
    fun mostrar(){
        println("Bienvenido a la Bibloteca, qué desea hacer?")
        println("1 -> Añadir un elementoBiblioteca")
        println("2 -> Eliminar un elementoBiblioteca")
        println("3 -> Registrar un préstamo")
        println("4 -> Devolver un elementoBiblioteca")
        println("5 -> Retornar los libros según su estado (todo, disponibles, prestados)")
        println("6 -> Consultar Historial Prestamos de un ElementoBiblioteca")
        println("8 -> Consultar Historial Prestamos de un Usuario")
        println("7 -> Salir")
    }
    private fun buscarElementoPorId(catalogo: List<ElementoBiblioteca<Any?>>): ElementoBiblioteca<Any?> {
        var id: String
        var elementoBiblioteca: ElementoBiblioteca<Any?>? = null
        while (elementoBiblioteca == null){
            println("Dime una id de un elementoBiblioteca que se encuentre en el catalogo: ")
            try {
                id = readln()
                elementoBiblioteca = catalogo.find { it.id == id }
            }catch (e:NumberFormatException){
                println("ID no válida")
            }
        }
        return elementoBiblioteca
    }
    private fun buscarElementoPorTitulo(catalogo: List<ElementoBiblioteca<Any?>>): ElementoBiblioteca<Any?> {
        var titulo: String?
        var elementoBiblioteca: ElementoBiblioteca<Any?>? = null
        while (elementoBiblioteca == null){
            println("Dime el nombre de un elementoBiblioteca que esté en el catalogo: ")
            titulo = readln()
            elementoBiblioteca = catalogo.find { it.titulo == titulo }
        }
        return elementoBiblioteca
    }
    fun preguntarBuscarElemento(catalogo: List<ElementoBiblioteca<Any?>>): ElementoBiblioteca<Any?> {
        var elementoBiblioteca: ElementoBiblioteca<Any?>? = null
        while (elementoBiblioteca == null){
            println("Cómo quieres buscar el elementoBiblioteca?")
            println("1 -> Por ID")
            println("2 -> Por titulo")
            elementoBiblioteca = when(readln().trim()){
                "1" -> buscarElementoPorId(catalogo)
                "2" -> buscarElementoPorTitulo(catalogo)
                else -> {
                    println("Opción no válida")
                    null
                }
            }
        }
        return elementoBiblioteca
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
    fun crearNuevoLibro(): Libro {
        println("Qué título quieres que tenga el elementoBiblioteca?")
        val titulo = readln().trim()

        println("Quién es el autor?")
        val autor = readln()

        var fechaDePublicacion:Int? = null
        while (fechaDePublicacion == null || fechaDePublicacion !in 1900..2024){
            println("Fecha de publicacion (entre 1900 y 2024): ")
            fechaDePublicacion = readln().toIntOrNull()
        }

        println("Tematica del elementoBiblioteca:")
        val tematica = readln()


        return Libro(titulo, autor, fechaDePublicacion, tematica)
    }
}
class Usuario(
    val nombre:String,
    private val librosPrestados:MutableList<ElementoBiblioteca<Any?>> = mutableListOf(),
    val id: String = UtilidadesBiblioteca().generarIdentificadorUnico()
) {
    fun agregarElementoBiblotecaPrestado(elementoBiblioteca: ElementoBiblioteca<Any?>){
        librosPrestados.add(elementoBiblioteca)
    }
    fun quitarElementoBiblotecaPrestado(elementoBiblioteca: ElementoBiblioteca<Any?>){
        librosPrestados.remove(elementoBiblioteca)
    }

    fun mostrarElementoBiblotecaPrestados():List<ElementoBiblioteca<Any?>>{
        return librosPrestados
    }
    init {
        require(nombre.isNotBlank()){ "El nombre no puede estar vacio"}
    }
}
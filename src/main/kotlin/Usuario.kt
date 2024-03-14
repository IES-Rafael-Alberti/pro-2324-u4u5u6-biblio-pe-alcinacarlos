class Usuario(
    val nombre:String,
    private val librosPrestados:MutableList<ElementoBiblioteca> = mutableListOf(),
    val id: String = UtilidadesBiblioteca().generarIdentificadorUnico()
) {
    fun agregarElementoBiblotecaPrestado(elementoBiblioteca: ElementoBiblioteca){
        librosPrestados.add(elementoBiblioteca)
    }
    fun quitarElementoBiblotecaPrestado(elementoBiblioteca: ElementoBiblioteca){
        librosPrestados.remove(elementoBiblioteca)
    }

    fun mostrarElementoBiblotecaPrestados():List<ElementoBiblioteca>{
        return librosPrestados
    }
    init {
        require(nombre.isNotBlank()){ "El nombre no puede estar vacio"}
    }
}
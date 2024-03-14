import org.pebiblioteca.Libro

class Usuario(
    val nombre:String,
    private val librosPrestados:MutableList<Libro> = mutableListOf(),
    val id: String = UtilidadesBiblioteca().generarIdentificadorUnico()
) {
    fun agregarLibroPrestado(libro: Libro){
        librosPrestados.add(libro)
    }
    fun quitarLibroPrestado(libro: Libro){
        librosPrestados.remove(libro)
    }

    fun mostrarLibrosPrestados():List<Libro>{
        return librosPrestados
    }
    init {
        require(nombre.isNotBlank()){ "El nombre no puede estar vacio"}
    }
}
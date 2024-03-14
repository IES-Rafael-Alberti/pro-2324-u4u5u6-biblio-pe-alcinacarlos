class Revista(
    override val titulo:String,
    val autor:String,
    val fechaDePublicacion:Int,
    val tematica:String,
    override var estado: Estado = Estado.DISPONIBLE,
    override val id:String = UtilidadesBiblioteca().generarIdentificadorUnico()
):Prestable, ElementoBiblioteca<Any?>(id, titulo, estado) {
    init {
        require(titulo.isNotBlank()){ "El título no puede estar vacio"}
        require(autor.isNotBlank()){ "El autor no puede estar vacio"}
    }

    override fun devolver() {
        estado = Estado.DISPONIBLE
    }

    override fun prestar() {
        estado = Estado.PRESTADO
    }

    override fun toString(): String {
        return "Revista: $titulo, ID: $id, Estado: $estado Autor: $autor, Año de publicacion: $fechaDePublicacion, Tematica $tematica"
    }
}
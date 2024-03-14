package org.pebiblioteca

class Libro(
    val id:Int,
    val título:String,
    val autor:String,
    val fecha_de_publicación:Int,
    val temática:Int,
    val estado:Estado = Estado.DISPONIBLE
) {
    init {
        require(título.isNotBlank()){ "El título no puede estar vacio"}
        require(autor.isNotBlank()){ "El autor no puede estar vacio"}
    }
}
//3. Crea una clase genérica Catalogo<T>; que almacene productos o libros.
//a) Agrega métodos para agregar y buscar elemento
//b) Prueba el catálogo con libros
//c) Prueba el catálogo con productos
import java.util.Objects; 

class Libro {
    private String titulo;
    private String autor;
    private String isbn; 

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }
    @Override
    public String toString() {
        return "Libro [Título: '" + titulo + "', Autor: '" + autor + "', ISBN: '" + isbn + "']";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

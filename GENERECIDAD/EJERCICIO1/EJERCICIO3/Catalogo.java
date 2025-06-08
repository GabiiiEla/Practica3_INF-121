import java.util.ArrayList;
import java.util.List; 

public class Catalogo<T> {
    private List<T> elementos; 
    public Catalogo() {
        this.elementos = new ArrayList<>();
    }
    public void agregarElemento(T elemento) {
        if (elemento != null) { 
            this.elementos.add(elemento);
            System.out.println("Agregado: " + elemento.toString());
        } else {
            System.out.println("No se puede agregar un elemento nulo al catálogo.");
        }
    }
    public T buscarElemento(String textoBusqueda) {
        if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
            System.out.println("El texto de búsqueda no puede estar vacío.");
            return null;
        }
        for (T elemento : elementos) {
            String nombreElemento = "";
            if (elemento instanceof Libro) {
                nombreElemento = ((Libro) elemento).getTitulo();
            } else if (elemento instanceof Producto) {
                nombreElemento = ((Producto) elemento).getNombre();
            } else {
                nombreElemento = elemento.toString();
            }
            if (nombreElemento.toLowerCase().contains(textoBusqueda.toLowerCase())) {
                return elemento;
            }
        }
        return null;
    }
    public void mostrarCatalogo() {
        if (elementos.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }
        System.out.println("\n--- Contenido del Catálogo ---");
        for (T elemento : elementos) {
            System.out.println(elemento);
        }
    }
}
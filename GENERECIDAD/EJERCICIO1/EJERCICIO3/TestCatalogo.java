public class TestCatalogo {
    public static void main(String[] args) {
        System.out.println("=== Catálogo de Libros ===");
        Catalogo<Libro> catalogoDeLibros = new Catalogo<>();

        Libro libro1 = new Libro("Orgullo y Prejuicio", "Jenn Austin", "978-0307455294");
        Libro libro2 = new Libro("La Ultima Nota", "Joana M", "978-8424119864");
        Libro libro3 = new Libro("Fabricante de lagrimas", "Erin Doom", "978-0156013915");

        catalogoDeLibros.agregarElemento(libro1);
        catalogoDeLibros.agregarElemento(libro2);
        catalogoDeLibros.agregarElemento(libro3);
        catalogoDeLibros.mostrarCatalogo();
        System.out.println("\nBuscando 'Libros' en el catálogo ");
        Libro encontradoLibro = catalogoDeLibros.buscarElemento("Fabricante de lagrimas");
        if (encontradoLibro != null) {
            System.out.println("Libro encontrado: " + encontradoLibro);
        } else {
            System.out.println("Libro no encontrado.");
        }

        System.out.println("\nBuscando 'Harry Potter' en el catálogo de libros");
        encontradoLibro = catalogoDeLibros.buscarElemento("Harry Potter");
        if (encontradoLibro != null) {
            System.out.println("Libro encontrado: " + encontradoLibro);
        } else {
            System.out.println("Libro no encontrado.");
        }

        System.out.println("\n Catálogo de Productos ");
        Catalogo<Producto> catalogoDeProductos = new Catalogo<>();

        Producto producto1 = new Producto("Laptop Gamer", 1200.00, "LG-X2023");
        Producto producto2 = new Producto("Teclado Mecánico", 85.50, "TM-RGB001");
        Producto producto3 = new Producto("Ratón Ergonómico", 25.99, "RE-WIRELESS");

        catalogoDeProductos.agregarElemento(producto1);
        catalogoDeProductos.agregarElemento(producto2);
        catalogoDeProductos.agregarElemento(producto3);

        catalogoDeProductos.mostrarCatalogo();

        System.out.println("\nBuscando 'Teclado' en el catálogo de productos");
        Producto encontradoProducto = catalogoDeProductos.buscarElemento("Teclado");
        if (encontradoProducto != null) {
            System.out.println("Producto encontrado: " + encontradoProducto);
        } else {
            System.out.println("Producto no encontrado.");
        }

        System.out.println("\nBuscando 'Monitor' en el catálogo de productos...");
        encontradoProducto = catalogoDeProductos.buscarElemento("Monitor");
        if (encontradoProducto != null) {
            System.out.println("Producto encontrado: " + encontradoProducto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
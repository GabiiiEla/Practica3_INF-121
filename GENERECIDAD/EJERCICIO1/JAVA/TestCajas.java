public class TestCajas {
    public static void main(String[] args) {
        Caja<String> cajaDeTexto = new Caja<>(); 
        cajaDeTexto.guardar("¡muchos libros!"); 
        Caja<Integer> cajaDeNumero = new Caja<>(); 
        cajaDeNumero.guardar(12321); 
        
        System.out.println("  ");
        System.out.println("Contenido de la primera caja (String): " + cajaDeTexto.obtener());
        System.out.println("Contenido de la segunda caja (Integer): " + cajaDeNumero.obtener());
    }
}
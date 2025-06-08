import java.util.EmptyStackException; 

public class MainPila {
    public static void main(String[] args) {

        System.out.println("--- PRUEBA CON PILA DE ENTEROS ---");
        Pila<Integer> pilaDeEnteros = new Pila<>();

        pilaDeEnteros.apilar(10);
        pilaDeEnteros.apilar(20);
        pilaDeEnteros.apilar(30);
        System.out.println(pilaDeEnteros); 
        pilaDeEnteros.mostrarPilaVisualmente();
        try {
            System.out.println("\nElemento en la cima (sin desapilar): " + pilaDeEnteros.verCima());
            pilaDeEnteros.desapilar(); 
            System.out.println(pilaDeEnteros);
            pilaDeEnteros.desapilar(); 
            System.out.println(pilaDeEnteros);
            System.out.println("Tamaño actual de la pila: " + pilaDeEnteros.tamano());
            pilaDeEnteros.desapilar(); 
            System.out.println(pilaDeEnteros);
            pilaDeEnteros.mostrarPilaVisualmente();

            System.out.println("\nIntentando desapilar de una pila vacía...");
            pilaDeEnteros.desapilar();
        } catch (EmptyStackException e) {
            System.out.println("Error: " + e.getMessage() + " - ¡La pila está vacía!");
        }

        System.out.println("\n\n--- PRUEBA CON PILA DE CADENAS (Strings) ---");
        Pila<String> pilaDeCadenas = new Pila<>();
        pilaDeCadenas.apilar("Primero");
        pilaDeCadenas.apilar("Segundo");
        pilaDeCadenas.apilar("Tercero");
        System.out.println(pilaDeCadenas);
        pilaDeCadenas.mostrarPilaVisualmente();

        try {
            System.out.println("\nElemento en la cima (sin desapilar): " + pilaDeCadenas.verCima());
            pilaDeCadenas.desapilar(); 
            System.out.println(pilaDeCadenas);
            pilaDeCadenas.desapilar(); 
            System.out.println(pilaDeCadenas);
            pilaDeCadenas.apilar("Cuarto"); 
            System.out.println(pilaDeCadenas);
            pilaDeCadenas.mostrarPilaVisualmente();
        } catch (EmptyStackException e) {
            System.out.println("Error: " + e.getMessage() + " - ¡La pila está vacía!");
        }
    }
}
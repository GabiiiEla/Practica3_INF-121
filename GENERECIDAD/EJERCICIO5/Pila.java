//Ejercicio 5: Crea una clase genérica Pila<T>
//a) Implementa un método para apilar
//b) Implementa un método para des apilar
//c) Prueba la pila con diferentes tipos de datos
//d) Muestra los datos de la pila

import java.util.ArrayList;
import java.util.EmptyStackException; 

public class Pila<T> {
    private ArrayList<T> elementos;

    public Pila() {
        this.elementos = new ArrayList<>();
    }

    public void apilar(T elemento) {
        elementos.add(elemento); 
        System.out.println("Apilado: " + elemento);
    }

    public T desapilar() {
        if (estaVacia()) {
            throw new EmptyStackException(); 
        }
        T elementoDesapilado = elementos.remove(elementos.size() - 1);
        System.out.println("Desapilado: " + elementoDesapilado);
        return elementoDesapilado;
    }
    public T verCima() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return elementos.get(elementos.size() - 1);
    }
    public boolean estaVacia() {
        return elementos.isEmpty();
    }
    @Override
    public String toString() {
        if (estaVacia()) {
            return "Pila: [Vacía]";
        }
        return "Pila: " + elementos.toString();
    }
    public void mostrarPilaVisualmente() {
        System.out.println("\n Contenido de la Pila (Cima a Base) ");
        if (estaVacia()) {
            System.out.println("Pila vacía.");
            return;
        }
        for (int i = elementos.size() - 1; i >= 0; i--) {
            System.out.println("| " + elementos.get(i) + " |");
            if (i > 0) {
                System.out.println("  ");
            }
        }
    }
    public int tamano() {
        return elementos.size();
    }
}
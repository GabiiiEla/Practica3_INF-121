//Crea una clase genérica Caja&lt;T&gt; para guardar algún tipo de objeto
//a) Agrega métodos guardar() y obtener()
//b) Crea dos instancias de la caja y almacena 2 datos de diferente tipo
//c) Muestra el contenido de las cajas

public class Caja<T> {
    
    private T contenido;
    public void guardar(T item) {
        this.contenido = item;
    }
    public T obtener() {
        return this.contenido;
    }
}
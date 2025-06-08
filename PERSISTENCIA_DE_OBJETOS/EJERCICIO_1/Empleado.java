import java.io.Serializable; // Importante: para que los objetos puedan ser serializados

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;
    private float salario;

    public Empleado(String nombre, int edad, float salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getSalario() {
        return salario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado [Nombre=" + nombre + ", Edad=" + edad + ", Salario=" + salario + "]";
    }
}
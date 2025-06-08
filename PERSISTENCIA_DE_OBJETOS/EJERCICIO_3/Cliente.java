import java.io.*;
import java.util.Objects;

class Cliente implements Serializable {
    private static final long serialVersionUID = 1L; 

    private int id;
    private String nombre;
    private int telefono; 

    public Cliente(int id, String nombre, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Cliente [ID: " + id + ", Nombre: '" + nombre + "', Teléfono: " + telefono + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id; 
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


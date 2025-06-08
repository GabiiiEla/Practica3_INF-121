import java.io.Serializable;
import java.util.Scanner;

class Medicamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int codMedicamento;
    private String tipo; 
    private double precio;

    public Medicamento() {
        this("", 0, "", 0.0);
    }
    public Medicamento(String nombre, int codMedicamento, String tipo, double precio) {
        this.nombre = nombre;
        this.codMedicamento = codMedicamento;
        this.tipo = tipo;
        this.precio = precio;
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese nombre del medicamento: ");
        this.nombre = sc.nextLine();
        System.out.print("Ingrese código del medicamento: ");
        this.codMedicamento = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese tipo del medicamento (ej: Resfrio, Tos, Dolor): ");
        this.tipo = sc.nextLine();
        System.out.print("Ingrese precio del medicamento: ");
        this.precio = sc.nextDouble();
        sc.nextLine(); 
    }

    public void mostrar() {
        System.out.println("  Medicamento: " + nombre + " (Cod: " + codMedicamento + ")");
        System.out.println("    Tipo: " + tipo + ", Precio: " + String.format("%.2f", precio));
    }
    public String getNombre() {
        return nombre;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
    @Override
    public String toString() {
        return "Medicamento [Nombre='" + nombre + "', Codigo=" + codMedicamento + ", Tipo='" + tipo + "', Precio=" + String.format("%.2f", precio) + "]";
    }
}
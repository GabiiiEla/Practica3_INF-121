import java.io.Serializable;
import java.util.Scanner;
import java.util.Arrays; 

class Farmacia implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private int nroMedicamentos;
    private Medicamento[] m; 

    public Farmacia() {
        this("", 0, "", 0);
        this.m = new Medicamento[100];
    }

    public Farmacia(String nombreFarmacia, int sucursal, String direccion, int nroMedicamentos) {
        this.nombreFarmacia = nombreFarmacia;
        this.sucursal = sucursal;
        this.direccion = direccion;
        this.nroMedicamentos = nroMedicamentos;
        this.m = new Medicamento[100]; 
    }

    public Farmacia(String nombreFarmacia, int sucursal, String direccion, Medicamento[] medicamentos, int nroMedicamentos) {
        this.nombreFarmacia = nombreFarmacia;
        this.sucursal = sucursal;
        this.direccion = direccion;
        this.nroMedicamentos = nroMedicamentos;
        this.m = new Medicamento[100];
        if (medicamentos != null && nroMedicamentos <= 100) {
            System.arraycopy(medicamentos, 0, this.m, 0, nroMedicamentos);
        } else if (medicamentos != null) {
            System.err.println("Advertencia: Se intentaron añadir más de 100 medicamentos a la farmacia " + nombreFarmacia);
            System.arraycopy(medicamentos, 0, this.m, 0, 100);
            this.nroMedicamentos = 100;
        }
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese nombre de la Farmacia: ");
        this.nombreFarmacia = sc.nextLine();
        System.out.print("Ingrese número de Sucursal: ");
        this.sucursal = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese dirección: ");
        this.direccion = sc.nextLine();
        System.out.print("¿Cuántos medicamentos desea registrar (máx 100)? ");
        this.nroMedicamentos = sc.nextInt();
        sc.nextLine(); 

        if (this.nroMedicamentos > 100) {
            System.out.println("Máximo 100 medicamentos. Se registrarán 100.");
            this.nroMedicamentos = 100;
        }

        this.m = new Medicamento[100]; 
        for (int i = 0; i < this.nroMedicamentos; i++) {
            System.out.println("  --- Medicamento " + (i + 1) + " ---");
            m[i] = new Medicamento();
            m[i].leer();
        }
    }

    // Método para mostrar datos de la farmacia y sus medicamentos
    public void mostrar() {
        System.out.println("\n--- Datos de la Farmacia ---");
        System.out.println("Nombre: " + nombreFarmacia);
        System.out.println("Sucursal: " + sucursal);
        System.out.println("Dirección: " + direccion);
        System.out.println("Número de medicamentos: " + nroMedicamentos);
        System.out.println("Medicamentos:");
        if (nroMedicamentos == 0) {
            System.out.println("  (No hay medicamentos registrados)");
        } else {
            for (int i = 0; i < nroMedicamentos; i++) {
                m[i].mostrar();
            }
        }
        System.out.println("");
    }
    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public int getSucursal() {
        return sucursal;
    }

    public String getDireccion() {
        return direccion;
    }
    public int getNroMedicamentos() {
        return nroMedicamentos;
    }
    public Medicamento[] getMedicamentos() {
        return Arrays.copyOf(m, nroMedicamentos);
    }

    public boolean adicionarMedicamento(Medicamento nuevoMed) {
        if (nroMedicamentos < 100) {
            m[nroMedicamentos] = nuevoMed;
            nroMedicamentos++;
            System.out.println("Medicamento '" + nuevoMed.getNombre() + "' añadido a " + nombreFarmacia);
            return true;
        } else {
            System.out.println("La farmacia '" + nombreFarmacia + "' no puede almacenar más medicamentos.");
            return false;
        }
    }

    public void mostrarMedicamentos(String tipoBusqueda) { 
        if (nroMedicamentos == 0) {
            System.out.println("  (No hay medicamentos registrados en esta farmacia)");
            return;
        }
        System.out.println("  Medicamentos en " + nombreFarmacia + " (Sucursal " + sucursal + "):");
        boolean encontrado = false;
        for (int i = 0; i < nroMedicamentos; i++) {
            if (tipoBusqueda == null || tipoBusqueda.isEmpty() || m[i].getTipo().equalsIgnoreCase(tipoBusqueda)) {
                m[i].mostrar();
                encontrado = true;
            }
        }
        if (!encontrado && tipoBusqueda != null && !tipoBusqueda.isEmpty()) {
            System.out.println("  No se encontraron medicamentos de tipo '" + tipoBusqueda + "'.");
        }
    }
    public Medicamento buscaMedicamento(int codBuscado) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getCodMedicamento() == codBuscado) {
                return m[i];
            }
        }
        return null; 
    }
}
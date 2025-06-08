import java.io.*; 
import java.util.ArrayList;
import java.util.List;

public class ArchivoEmpleado {
    private String nombreArchivo;

    public ArchivoEmpleado(String n) {
        this.nombreArchivo = n;
    }
    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(new ArrayList<Empleado>());
            System.out.println("Archivo '" + nombreArchivo + "' creado o inicializado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al crear/inicializar el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void guardarEmpleado(Empleado e) {
        List<Empleado> empleadosActuales = leerEmpleados(); 
        empleadosActuales.add(e); 

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(empleadosActuales); 
            System.out.println("Empleado '" + e.getNombre() + "' guardado exitosamente en el archivo.");
        } catch (IOException ex) {
            System.err.println("Error al guardar empleado: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        File archivo = new File(nombreArchivo);

        if (!archivo.exists() || archivo.length() == 0) {
            return empleados;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Object obj = ois.readObject();
            if (obj instanceof List) { 
                empleados = (List<Empleado>) obj;
            }
        } catch (FileNotFoundException e) {

            System.err.println("Archivo no encontrado al leer: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de IO al leer empleados: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Clase Empleado no encontrada al leer: " + e.getMessage());
        }
        return empleados;
    }

    public Empleado buscaEmpleado(String n) {
        List<Empleado> empleados = leerEmpleados();
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(n)) { 
                return emp;
            }
        }
        return null;
    }
    public Empleado mayorSalario(float sueldo) {
        List<Empleado> empleados = leerEmpleados();
        for (Empleado emp : empleados) {
            if (emp.getSalario() > sueldo) {
                return emp; 
            }
        }
        return null; 
    }
    public void mostrarDatosArchivo() {
        List<Empleado> empleados = leerEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("\nEl archivo de empleados está vacío.");
        } else {
            System.out.println("\n--- Datos de Empleados en el Archivo ---");
            for (Empleado emp : empleados) {
                System.out.println(emp);
            }
        }
    }
}

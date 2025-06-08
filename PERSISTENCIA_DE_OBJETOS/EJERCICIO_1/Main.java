public class Main {
    public static void main(String[] args) {
        String nombreArchivo = "empleados.dat"; 

        ArchivoEmpleado gestorEmpleados = new ArchivoEmpleado(nombreArchivo);

        gestorEmpleados.crearArchivo();

        Empleado emp1 = new Empleado("Juan Perez", 30, 1500.0f);
        Empleado emp2 = new Empleado("Maria Lopez", 25, 1800.50f);
        Empleado emp3 = new Empleado("Carlos Garcia", 45, 2200.75f);
        Empleado emp4 = new Empleado("Ana Fernandez", 35, 1650.0f);

        System.out.println("\n--- Guardando Empleados ---");
        gestorEmpleados.guardarEmpleado(emp1);
        gestorEmpleados.guardarEmpleado(emp2);
        gestorEmpleados.guardarEmpleado(emp3);
        gestorEmpleados.guardarEmpleado(emp4);

        gestorEmpleados.mostrarDatosArchivo();

        System.out.println("\n Buscando Empleados ");
        String nombreBuscar1 = "Maria Lopez";
        Empleado encontrado1 = gestorEmpleados.buscaEmpleado(nombreBuscar1);
        if (encontrado1 != null) {
            System.out.println("Empleado '" + nombreBuscar1 + "' encontrado: " + encontrado1);
        } else {
            System.out.println("Empleado '" + nombreBuscar1 + "' no encontrado.");
        }

        String nombreBuscar2 = "Pedro Martinez";
        Empleado encontrado2 = gestorEmpleados.buscaEmpleado(nombreBuscar2);
        if (encontrado2 != null) {
            System.out.println("Empleado '" + nombreBuscar2 + "' encontrado: " + encontrado2);
        } else {
            System.out.println("Empleado '" + nombreBuscar2 + "' no encontrado.");
        }

        System.out.println("\n Buscando Empleado con Salario Mayor ");
        float salarioReferencia1 = 2000.0f;
        Empleado conMayorSalario1 = gestorEmpleados.mayorSalario(salarioReferencia1);
        if (conMayorSalario1 != null) {
            System.out.println("Primer empleado con salario mayor a " + salarioReferencia1 + ": " + conMayorSalario1);
        } else {
            System.out.println("Ningún empleado tiene salario mayor a " + salarioReferencia1);
        }

        float salarioReferencia2 = 3000.0f;
        Empleado conMayorSalario2 = gestorEmpleados.mayorSalario(salarioReferencia2);
        if (conMayorSalario2 != null) {
            System.out.println("Primer empleado con salario mayor a " + salarioReferencia2 + ": " + conMayorSalario2);
        } else {
            System.out.println("Ningún empleado tiene salario mayor a " + salarioReferencia2);
        }
        System.out.println("\n Recargando Archivo para Verificar Persistencia ");
        ArchivoEmpleado gestorEmpleadosRecargado = new ArchivoEmpleado(nombreArchivo);
        gestorEmpleadosRecargado.mostrarDatosArchivo(); 
    }
}
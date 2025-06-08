import java.util.Scanner;

public class PruebaFarmacia {
    public static void main(String[] args) {
        String nombreArchivoFarmacias = "farmacias.dat";
        ArchFarmacia gestorArchFarmacia = new ArchFarmacia(nombreArchivoFarmacias);
        gestorArchFarmacia.crearArchivo();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión de Farmacias y Medicamentos ---");
            System.out.println("1. Adicionar una nueva Farmacia");
            System.out.println("2. Listar todas las Farmacias guardadas");
            System.out.println("3. Mostrar medicamentos para la tos de una Sucursal específica (Punto b)");
            System.out.println("4. Mostrar sucursal y dirección con el medicamento 'Golpex' (Punto c)");
            System.out.println("5. (Opcional) Mostrar todos los medicamentos de Resfrio");
            System.out.println("6. (Opcional) Calcular precio total de medicamentos para la Tos");
            System.out.println("7. (Opcional) Mostrar medicamento de Tos con menor precio");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    Farmacia nuevaFarmacia = new Farmacia();
                    nuevaFarmacia.leer(); 
                    gestorArchFarmacia.adicionar(nuevaFarmacia);
                    break;
                case 2:
                    gestorArchFarmacia.listar(); 
                    break;
                case 3:
                    System.out.print("Ingrese el número de sucursal para buscar medicamentos de Tos: ");
                    int sucBusqueda = sc.nextInt();
                    sc.nextLine();
                    gestorArchFarmacia.mostrarMedicamentosTosDeSucursal(sucBusqueda); 
                    break;
                case 4:
                    
                    gestorArchFarmacia.mostrarSucursalesConMedicamento("Golpex");
                    break;
                case 5:
                    gestorArchFarmacia.mostrarMedicamentosResfrios();
                    break;
                case 6:
                    gestorArchFarmacia.precioMedicamentoTos();
                    break;
                case 7:
                    gestorArchFarmacia.mostrarMedicamentosMenorTos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
        System.out.println("Programa finalizado.");
    }
}
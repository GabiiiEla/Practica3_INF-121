import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ArchFarmacia {
    private String na; 
    public ArchFarmacia(String na) {
        this.na = na;
    }
    public void crearArchivo() {
        try {
            File file = new File(na);
            if (file.createNewFile()) {
                System.out.println("Archivo '" + na + "' creado exitosamente.");
            } else {
                System.out.println("El archivo '" + na + "' ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear/verificar el archivo: " + e.getMessage());
        }
    }

    
    public void adicionar(Farmacia f) {
    
        List<Farmacia> farmaciasExistentes = leerTodasLasFarmacias();
        farmaciasExistentes.add(f); 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(na))) {
            oos.writeObject(farmaciasExistentes);
            System.out.println("Farmacia '" + f.getNombreFarmacia() + "' (Sucursal " + f.getSucursal() + ") guardada en '" + na + "'.");
        } catch (IOException e) {
            System.err.println("Error al guardar farmacia en el archivo: " + e.getMessage());
        }
    }

    private List<Farmacia> leerTodasLasFarmacias() {
        List<Farmacia> farmacias = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(na))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                farmacias.addAll((List<Farmacia>) obj);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo '" + na + "' no encontrado. Se creará uno nuevo al guardar.");
        } catch (EOFException e) {
            System.out.println("Archivo vacío o formato incorrecto. Se iniciará una nueva lista.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer farmacias del archivo: " + e.getMessage());
        }
        return farmacias;
    }

    public void listar() {
        List<Farmacia> farmacias = leerTodasLasFarmacias();
        if (farmacias.isEmpty()) {
            System.out.println("\n--- No hay farmacias guardadas en '" + na + "'. ---");
        } else {
            System.out.println("\n--- Farmacias guardadas en '" + na + "': ---");
            for (Farmacia farmacia : farmacias) {
                farmacia.mostrar(); 
            }
            System.out.println("------------------------------------------");
        }
    }

    public void mostrarMedicamentosTosDeSucursal(int sucursalX) {
        System.out.println("\n--- Medicamentos para la Tos en Sucursal " + sucursalX + " ---");
        List<Farmacia> farmacias = leerTodasLasFarmacias();
        boolean sucursalEncontrada = false;
        boolean medicamentosEncontrados = false;

        for (Farmacia farmacia : farmacias) {
            if (farmacia.getSucursal() == sucursalX) {
                sucursalEncontrada = true;
                Medicamento[] medicamentos = farmacia.getMedicamentos();
                if (farmacia.getNroMedicamentos() > 0) {
                    System.out.println("Farmacia: " + farmacia.getNombreFarmacia() + ", Dirección: " + farmacia.getDireccion());
                    for (int i = 0; i < farmacia.getNroMedicamentos(); i++) {
                        if (medicamentos[i].getTipo().equalsIgnoreCase("Tos")) {
                            medicamentos[i].mostrar();
                            medicamentosEncontrados = true;
                        }
                    }
                }
                break; 
            }
        }

        if (!sucursalEncontrada) {
            System.out.println("Sucursal " + sucursalX + " no encontrada.");
        } else if (!medicamentosEncontrados) {
            System.out.println("No se encontraron medicamentos para la tos en la Sucursal " + sucursalX + ".");
        }
        System.out.println("-------------------------------------------------");
    }

    public void mostrarSucursalesConMedicamento(String nombreMedicamento) {
        System.out.println("\n--- Sucursales con el medicamento '" + nombreMedicamento + "' ---");
        List<Farmacia> farmacias = leerTodasLasFarmacias();
        boolean encontradoAlgunaSucursal = false;

        for (Farmacia farmacia : farmacias) {
            Medicamento[] medicamentos = farmacia.getMedicamentos();
            for (int i = 0; i < farmacia.getNroMedicamentos(); i++) {
                if (medicamentos[i].getNombre().equalsIgnoreCase(nombreMedicamento)) {
                    System.out.println("  Sucursal: " + farmacia.getSucursal() + ", Dirección: " + farmacia.getDireccion());
                    encontradoAlgunaSucursal = true;
                    break; 
                }
            }
        }

        if (!encontradoAlgunaSucursal) {
            System.out.println("No se encontraron sucursales con el medicamento '" + nombreMedicamento + "'.");
        }
        System.out.println("----------------------------------------------------------");
    }

    public void mostrarMedicamentosResfrios() {
        System.out.println("\n--- Todos los medicamentos de tipo 'Resfrio' en todas las farmacias ---");
        List<Farmacia> farmacias = leerTodasLasFarmacias();
        boolean encontrado = false;
        for (Farmacia farmacia : farmacias) {
            Medicamento[] medicamentos = farmacia.getMedicamentos();
            if (farmacia.getNroMedicamentos() > 0) {
                for (int i = 0; i < farmacia.getNroMedicamentos(); i++) {
                    if (medicamentos[i].getTipo().equalsIgnoreCase("Resfrio")) {
                        System.out.println("  Farmacia: " + farmacia.getNombreFarmacia() + " (Suc: " + farmacia.getSucursal() + ")");
                        medicamentos[i].mostrar();
                        encontrado = true;
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron medicamentos de tipo 'Resfrio' en ninguna farmacia.");
        }
        System.out.println("------------------------------------------------------------------");
    }

    public double precioMedicamentoTos() {
        System.out.println("\n--- Calculando precio total de medicamentos de tipo 'Tos' ---");
        List<Farmacia> farmacias = leerTodasLasFarmacias();
        double precioTotalTos = 0.0;
        for (Farmacia farmacia : farmacias) {
            Medicamento[] medicamentos = farmacia.getMedicamentos();
            if (farmacia.getNroMedicamentos() > 0) {
                for (int i = 0; i < farmacia.getNroMedicamentos(); i++) {
                    if (medicamentos[i].getTipo().equalsIgnoreCase("Tos")) {
                        precioTotalTos += medicamentos[i].getPrecio();
                    }
                }
            }
        }
        System.out.println("El precio total de todos los medicamentos para la tos es: " + String.format("%.2f", precioTotalTos));
        System.out.println("-----------------------------------------------------------");
        return precioTotalTos;
    }

    public void mostrarMedicamentosMenorTos() {
        System.out.println("\n--- Medicamento de tipo 'Tos' con el precio más bajo ---");
        List<Farmacia> farmacias = leerTodasLasFarmacias();
        Medicamento medicamentoMasBarato = null;
        double precioMinimo = Double.MAX_VALUE;

        for (Farmacia farmacia : farmacias) {
            Medicamento[] medicamentos = farmacia.getMedicamentos();
            if (farmacia.getNroMedicamentos() > 0) {
                for (int i = 0; i < farmacia.getNroMedicamentos(); i++) {
                    if (medicamentos[i].getTipo().equalsIgnoreCase("Tos")) {
                        if (medicamentos[i].getPrecio() < precioMinimo) {
                            precioMinimo = medicamentos[i].getPrecio();
                            medicamentoMasBarato = medicamentos[i];
                        }
                    }
                }
            }
        }

        if (medicamentoMasBarato != null) {
            System.out.println("El medicamento para la tos más barato es:");
            medicamentoMasBarato.mostrar();
            System.out.println("Encontrado en alguna farmacia.");  
        } else {
            System.out.println("No se encontraron medicamentos de tipo 'Tos' en ninguna farmacia.");
        }
        System.out.println("------------------------------------------------------------------");
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ArchivoCliente {
    private String nomA; 

    public ArchivoCliente(String n) {
        this.nomA = n;
    }

    public void crearArchivo() {
        try {
            File file = new File(nomA);
            if (file.createNewFile()) {
            }
            else {
                System.out.println("El archivo '" + nomA + "' ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear/verificar el archivo: " + e.getMessage());
        }
    }

    public void guardaCliente(Cliente c) {
        List<Cliente> clientesExistentes = leerTodosLosClientes();
        clientesExistentes.add(c); 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(clientesExistentes);
            System.out.println("Cliente '" + c.getNombre() + "' guardado en '" + nomA + "'.");
        } catch (IOException e) {
            System.err.println("Error al guardar cliente en el archivo: " + e.getMessage());
        }
    }

    private List<Cliente> leerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomA))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                clientes.addAll((List<Cliente>) obj);
            }
        } catch (FileNotFoundException e) {
           
            System.out.println("Archivo '" + nomA + "' no encontrado. Se creará uno nuevo al guardar.");
        } catch (EOFException e) {
        
            System.out.println("Archivo vacío o formato incorrecto. Se iniciará una nueva lista.");
        }
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer clientes del archivo: " + e.getMessage());
        }
        return clientes;
    }
    public Cliente buscarCliente(int idBuscado) {
        List<Cliente> clientes = leerTodosLosClientes(); 
        for (Cliente cliente : clientes) {
            if (cliente.getId() == idBuscado) {
                System.out.println("Cliente encontrado por ID: " + cliente.getNombre());
                return cliente;
            }
        }
        System.out.println("Cliente con ID " + idBuscado + " no encontrado.");
        return null; 
    }
    public Cliente buscarCelularCliente(int idBuscado) {
        Cliente clienteEncontrado = buscarCliente(idBuscado);
        if (clienteEncontrado != null) {
            System.out.println("Datos del cliente encontrados para ID " + idBuscado + ":");
            System.out.println("  Nombre: " + clienteEncontrado.getNombre());
            System.out.println("  Teléfono: " + clienteEncontrado.getTelefono());
            return clienteEncontrado;
        } else {
            System.out.println("No se encontró cliente con ID " + idBuscado + " para obtener su celular.");
            return null;
        }
    }
    public void mostrarTodosLosClientes() {
        List<Cliente> clientes = leerTodosLosClientes();
        if (clientes.isEmpty()) {
            System.out.println("\n No hay clientes guardados en '" + nomA + "'. ");
        } else {
            System.out.println("\nClientes guardados en '" + nomA + "': ");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }
}

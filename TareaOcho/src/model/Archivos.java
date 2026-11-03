package model;

import java.io.*;
import java.util.ArrayList;

public class Archivos {

    public static final String NOMBRE_ARCHIVO = "productos.txt";
    public static final String VENTAS_ARCHIVO = "ventas.txt";
    public static File fileProductos = new File(NOMBRE_ARCHIVO);
    public static File fileVentas = new File(VENTAS_ARCHIVO);
    private static ArrayList<Producto> listaTemporal = new ArrayList<>();

    public static void guardarProductos(Producto producto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {

            bw.write(producto.toString());
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public static void leerArchivoProductos() {
        if (fileProductos.length() == 0) {
            System.out.println("Archivo vacio");
            return;
        } else {
            Datos.productos().clear();
            try (BufferedReader br = new BufferedReader(new FileReader(fileProductos))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split("; ");

                    int codigo = Integer.parseInt(partes[0]);
                    double precio = Double.parseDouble(partes[2]);
                    int cantidad = Integer.parseInt(partes[3]);

                    Producto producto = new Producto(codigo, partes[1], precio, cantidad);
                    Datos.productos().add(producto);
                    Datos.nombresProductos().add(partes[1]);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error de formato de número: " + e.getMessage());
            }
        }
    }

    public static void actualizarProducto(Producto producto) {

        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split("; ");
                int codigo = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                double precio = Double.parseDouble(partes[2]);
                int cantidad = Integer.parseInt(partes[3]);

                if (codigo == producto.getCodigo()) {
                    listaTemporal.add(producto);
                } else {
                    Producto p = new Producto(codigo, nombre, precio, cantidad);
                    listaTemporal.add(p);
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileProductos))) {
                for (Producto pr : listaTemporal) {
                    bw.write(pr.toString());
                    bw.newLine();
                }
            }
            leerArchivoProductos();
            listaTemporal.clear();
        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }
    }

    public static void guardarVenta(String venta) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileVentas, true))) {
            bw.write(venta);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

    }

    public static void leerArchivoVentas() {

        if (fileVentas.length() == 0) {
            System.out.println("Archivo vacio");
            return;

        } else {
            Datos.ventas().clear();
            try (BufferedReader br = new BufferedReader(new FileReader(fileVentas))) {
                String linea;
                while((linea = br.readLine()) != null){
                    Datos.ventas().add(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }
}

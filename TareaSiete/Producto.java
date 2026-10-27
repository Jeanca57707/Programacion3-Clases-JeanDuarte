import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static File inventario = new File("inventario.txt");

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para registrar un producto y guardarlo en el archivo
    public void registrarProducto(Scanner sc) {

        try {
            if (inventario.createNewFile()) {
                System.out.println("El archivo fue creado.");
            } else {
                System.out.println("El archivo ya existe");
            }
            sc.nextLine();

            System.out.print("Codigo del producto: ");
            String codigo = sc.nextLine();

            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine();

            System.out.print("Precio del producto: ");
            double precio = sc.nextDouble();

            System.out.print("Cantidad del producto: ");
            int cantidad = sc.nextInt();

            if (verificarCodigo(codigo)) {
                System.out.println("Ya ahí un producto con este código");
                return;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.txt", true))) {
                bw.write(codigo + "; " + nombre + "; " + precio + "; " + cantidad);
                bw.newLine();
            }
            Producto producto = new Producto(codigo, nombre, precio, cantidad);
            productos.add(producto);
            System.out.println("¡Producto registrado correctamente!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean verificarCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().toLowerCase().equals(codigo.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    // Método para consultar el inventario a traves del archivo "inventario.txt"
    public void consultarInventario() {

        try {
            if (inventario.length() == 0) {
                System.out.println("El archivo esta vacio");
            } else {
                System.out.println("\nProductos del inventario: \n");
                try (BufferedReader br = new BufferedReader(new FileReader(inventario))) {

                    String linea;
                    while ((linea = br.readLine()) != null) {

                        System.out.println(linea);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para buscar un producto en el archivo
    public void busquedaDeProducto(Scanner sc) {

        sc.nextLine();
        boolean encontrado = false;
        System.out.print("Código del producto: ");
        String codProd = sc.nextLine();

        try {
            if (inventario.length() == 0) {
                System.out.println("El inventario esta vacio");

            } else {

                try (BufferedReader br = new BufferedReader(new FileReader(inventario))) {

                    String linea;
                    while ((linea = br.readLine()) != null) {
                        if (linea.contains(codProd)) {
                            System.out.println("¡Producto encontrado!");
                            System.out.println(linea);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("\nProducto no encontrado");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    // Método para calcular el valor total del inventario
    public double valorInventario() {

        double valorTotal = 0;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(inventario))) {
                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] producto = linea.split("; ");
                    double precio = Double.parseDouble(producto[2]);
                    int cantidad = Integer.parseInt(producto[3]);

                    valorTotal += precio * cantidad;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return valorTotal;
    }

    public void crearCopia(){

        
    }
}

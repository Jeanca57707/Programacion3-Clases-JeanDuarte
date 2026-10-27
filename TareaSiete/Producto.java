import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Producto implements Serializable {

    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static final File inventario = new File("inventario.txt");

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

    @Override 
    public String toString(){
        return getCodigo() + " | " +getNombre() + " | " +getPrecio() + " | " +getCantidad();
    }

    // Método para registrar un producto y guardarlo en el archivo
    public void registrarProducto(Scanner sc) {

        try {
            if (inventario.createNewFile()) {
                System.out.println("El archivo fue creado.\n");
            } else {
                System.out.println("El archivo ya existe.\n");
            }

            System.out.print("Codigo del producto: ");
            String codigo = sc.nextLine();

            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine();

            System.out.print("Precio del producto: ");
            double precio = sc.nextDouble();

            System.out.print("Cantidad del producto: ");
            int cantidad = sc.nextInt();

            if (verificarCodigo(codigo)) {
                System.out.println("\nYa hay un producto con este código");
                return;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.txt", true))) {
                bw.write(codigo + "; " + nombre + "; " + precio + "; " + cantidad);
                bw.newLine();
            }
            Producto producto = new Producto(codigo, nombre, precio, cantidad);
            productos.add(producto);
            System.out.println("\n¡Producto registrado correctamente!");

        } catch (IOException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    public boolean verificarCodigo(String codigo) {
        try {
            if (inventario.length() == 0) {
                return false;

            } else {
                try (BufferedReader br = new BufferedReader(new FileReader(inventario))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        if (linea.toLowerCase().contains(codigo.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    // Método para consultar el inventario a traves del archivo "inventario.txt"
    public void consultarInventario() {

        try {
            if (inventario.length() == 0) {
                System.out.println("\nEl archivo esta vacio");
            } else {
                System.out.println("\nProductos del inventario: \n");
                System.out.printf("%-15s\t%-25s\t%-20s\t%-15s\n", "CODIGO", "NOMBRE", "PRECIO", "CANTIDAD");
                try (BufferedReader br = new BufferedReader(new FileReader(inventario))) {

                    String linea;
                    while ((linea = br.readLine()) != null) {
                        leerProducto(linea);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    // Método para buscar un producto en el archivo
    public void busquedaDeProducto(Scanner sc) {

        boolean encontrado = false;
        System.out.print("\nCódigo del producto: ");
        String codProd = sc.nextLine();

        try {
            if (inventario.length() == 0) {
                System.out.println("\nEl inventario esta vacio");

            } else {

                try (BufferedReader br = new BufferedReader(new FileReader(inventario))) {

                    String linea;
                    while ((linea = br.readLine()) != null) {
                        if (linea.toLowerCase().contains(codProd.toLowerCase())) {
                            System.out.println("\n¡Producto encontrado!\n");
                            System.out.printf("%-15s\t%-25s\t%-20s\t%-15s\n", "CODIGO", "NOMBRE", "PRECIO", "CANTIDAD");
                            leerProducto(linea);
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

    public void leerProducto(String cadena) {
        String[] producto = cadena.split("; ");
        try {
            double precio = Double.parseDouble(producto[2]);
            System.out.printf("%-15s\t%-25s\tRD$%-20.2f\t%-15s\n", producto[0], producto[1], precio, producto[3]);

        } catch (NumberFormatException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    // Método para crear una copia de seguridad del inventario
    public void crearCopia() {

        try {
            if (inventario.length() == 0) {
                System.out.println("\nNo hay nada registrado aún.");
            } else {
                try (BufferedReader br = new BufferedReader(new FileReader(inventario));
                        ObjectOutputStream archivoSerializable = new ObjectOutputStream(
                                new FileOutputStream("inventario.dat"))) {

                    String linea;

                    while ((linea = br.readLine()) != null) {
                        String[] partes = linea.split("; ");
                        double precio = Double.parseDouble(partes[2]);
                        int cantidad = Integer.parseInt(partes[3]);

                        Producto producto = new Producto(partes[0], partes[1], precio, cantidad);

                        archivoSerializable.writeObject(producto);
                    }
                }
                System.out.println("\n¡Copia creada correctamente!");

            }
        } catch (IOException e) {
            System.out.println("\nError: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("\nError: " + e.getMessage());
        }

    }

    // Método para recuperar una copia del inventario
    public void recuperarCopia() {

        try (ObjectInputStream lecturaSerializable = new ObjectInputStream(new FileInputStream("inventario.dat"))) {

            while (true) {
                Producto producto = (Producto) lecturaSerializable.readObject();
                productos.add(producto);
                System.out.println(producto.toString());
            }

        } catch (IOException e) {
            System.out.println("\nError: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        System.out.println("\n¡Copia restaurada completamente!");
    }
}

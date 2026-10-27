import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Producto p = new Producto();
        menu(p);
    }

    public static void menu(Producto producto) {

        Scanner sc = new Scanner(System.in);
        int opc = 0;

        do {
            System.out.println("\n=============================");
            System.out.println("         TECHSTORE           ");
            System.out.println("=============================\n");
            System.out.println("1. Registrar Producto.");
            System.out.println("2. Consultar Inventario.");
            System.out.println("3. Buscar Producto.");
            System.out.println("4. Calcular Producto.");
            System.out.println("5. Crear Copia de Seguridad.");
            System.out.println("6. Recuperar copia de Seguridad.");
            System.out.println("7. Salir.");
            System.out.print("\nELija una opción: ");

            try {
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1:
                        producto.registrarProducto(sc);
                        break;

                    case 2:
                        producto.consultarInventario();
                        break;

                    case 3:
                        producto.busquedaDeProducto(sc);
                        break;

                    case 4:
                       System.out.println("\nValor total: " + String.format("RD$%.2f", producto.valorInventario()));
                        break;

                    case 5:
                        producto.crearCopia();
                        break;

                    case 6:
                        producto.recuperarCopia();
                        break;
                        
                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;
                
                    default:
                        System.out.println("\nOpcion invalida");
                        break;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("\nIngrese un número válido");
                sc.nextLine();
            }
        } while (opc != 7);
    }
}
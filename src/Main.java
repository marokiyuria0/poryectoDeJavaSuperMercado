import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("SELECCIONE UNA OPCION.\n");

            System.out.println("1. AGREGAR PRODUCTO.");
            System.out.println("2. ELIMINAR PRODUCTO.");
            System.out.println("3. VER REGISTROS Y/O VENTAS.");
            System.out.println("4. PROCESAR VENTAS.");
            System.out.println("5. GESTIONAR PRODUCTO.");
            System.out.println("6. CERRAR PROGRAMA.");


            while (!leer.hasNextInt()) {
                System.out.println("Error: ingrese un número válido.");
                leer.next();
            }

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    menuAgregar v1 = new menuAgregar();
                    v1.ejecutarAgregar();
                    break;
                case 2:
                    menuEliminar v2 = new menuEliminar();
                    v2.ejecutar();
                    break;
                case 3:
                    menuRegistrosOventas v3 = new menuRegistrosOventas();
                    v3.ejecutar();
                    break;
                case 4:
                    menuProcesarVentas v4 = new menuProcesarVentas();
                    v4.ejecutar();
                    break;
                case 5:
                    menuGestionProducto v5 = new menuGestionProducto();
                    v5.ejecutar();
                    break;
                case 6:
                    System.out.println("CERRANDO PROGRAMA...");
                    break;
                default:
                    System.out.println("OPCION NO VALIDA\n");
            }

        } while (opcion != 6);

        System.out.println("PROGRAMA CERRADO...");
    }
}
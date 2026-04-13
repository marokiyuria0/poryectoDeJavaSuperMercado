import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("SELECCIONE UNA OPCION.\n");

            System.out.println("1. AGREGAR PRODUCTO");
            System.out.println("2. VER REGISTROS Y/O VENTAS");
            System.out.println("3. PROCESAR VENTAS");
            System.out.println("4. GESTIONAR PRODUCTO");
            System.out.println("5. CERRAR PROGRAMA");

            opcion = leer.nextInt();

            switch(opcion) {
                case 1:
                    MenuAgregar.ejecutarAgregar();
                    break;
/*
                case 2:
                    menuRegistrosOventas v3 = new menuRegistrosOventas();
                    v3.ejecutar();
                    break;
                case 3:
                    menuProcesarVentas v4 = new menuProcesarVentas();
                    v4.ejecutar();
                    break;
                case 4:
                    MenuGestionar v5 = new MenuGestionar();
                    v5.ejecutarGestion();
                    break;

 */
                case 5:
                    System.out.println("CERRANDO PROGRAMA....");
                    break;
                default:
                    System.out.println("OPCION NO VALIDA\n");
            }

        } while(opcion != 5);

        System.out.println("PROGRAMA CERRADO....");
        System.exit(0);
    }
}
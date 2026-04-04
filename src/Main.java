import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner leer= new Scanner(System.in);
        int opcion;

        do {
            system.out.println("SELECCIONE UNA OPCION.\n\n");

            system.out.println("1.AGREGAR PRODUCTO.\n");
            system.out.println("2.ELIMINAR PRODUCTO.\n");
            system.out.println("3.VER REGISTROS Y/O VENTAS.\n");
            system.out.println("4. PROCESAR VENTAS.\n");
            system.out.println("5. GESTIONAR PRODUCTO.\n");
            system.out.println("6. CERRAR PROGRAMA.\n");

            while (!leer.hasNextInt()) {
                System.out.println("Error: ingrese un número válido.");
                leer.next();

            opcion = leer.nextInt();

            switch(opcion) {
                case 1:
                    menuAgregar v1 = new menuAgregar(); v1.ejecutar(); break;
                case 2:
                    menuEliminar v2 = new menuEliminar(); v2.ejecutar(); break;
                case 3:
                    menuRegistrosOventas v3 = new menuRegistrosOventas(); v3.ejecutar(); break;
                case 4:
                    menuProcesarVentas v4 = new menuProcesarVentas(); v4.ejecutar(); break;
                case 5:
                    menuGestionProducto v5 = new menuGestionProducto(); v5.ejecutar(); break;
                case 6:
                    System.out.println("CERRANDO PROGRAMA...."); break;
                default:
                    System.out.println("OPCION NO VALIDA\n\n");
            }


        } while(opcion != 6);
        system.out.println("PROGRAMA CERRADO....");
        system.exit(0);
    }
}
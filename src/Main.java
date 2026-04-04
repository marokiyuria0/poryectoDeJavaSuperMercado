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
            opcion = leer.nextInt();

            switch(opcion){
                case 1: menuAgregar(); break;
                case 2: menuEliminar(); break;
                case 3: menuRegistrosOventas(); break;
                case 4: menuProcesarVentas(); break;
                case 5: menuGestionProducto(); break;
                case 6: System.out.println("CERRANDO PROGRAMA...."); break;
                default: System.out.println("OPCION NO VALIDA\n\n");
            }


        } while(opcion != 6);
        System.out.println("PROGRAMA CERRADO....");
        System.exit(0);
    }
}
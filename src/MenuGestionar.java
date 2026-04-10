import java.util.Scanner;

public class MenuGestionar {
    public static void ejecutarGestion(){

        Scanner leer = new Scanner(System.in);
        String codigoBuscado;
        int indiceProducto = -1;

        System.out.println("====================================\n");
        System.out.println("MENU PARA GESTIONAR PRODUCTO\n");
        System.out.println("====================================\n\n");
        System.out.println("INGRESE CODIGO DE PRODUCTO A BUSCAR, PARA SALIR DE ESTE MENU INGRESE 0000\n");


        while(true){
            codigoBuscado = leer.next();
            indiceProducto = -1;

            if ("0000".equals(codigoBuscado)){
                return;
            }
            for (int i = 0; i < Inventario.lista.size(); i++) {
                if (codigoBuscado.equals(Inventario.lista.get(i).getCodigo())) {
                    indiceProducto = i;
                    break;
                }
            }

            if(indiceProducto == -1){
                System.out.println("PRODUCTO NO ENCONTRADO, INGRESE EL CODIGO NUEVAMENTE O PARA SALIR DE ESTA SECCION INGRESE 0000\n\n");
                codigoBuscado = leer.next();
                if ("0000".equals(codigoBuscado)){
                    return;
                }
            }

            if(indiceProducto != -1){
                System.out.println("PRODUCTO ENCONTRADO\n\n\n");
                break;
            }

        }

        System.out.println("DATOS DEL PRODUCTO\n\n");
        System.out.println("NOMBRE DEL PRODUCTO : " + Inventario.lista.get(indiceProducto).getNombre());
        System.out.println("\n PRECIO DEL PRODUCTO : " + Inventario.lista.get(indiceProducto).getPrecio());
        System.out.println("\nCANTIDAD DE STOCK DEL PRODUCTO: "+ Inventario.lista.get(indiceProducto).getStock().getCantidadStock());

        System.out.println("\n\nGESTION DE PRODUCTO\n\n");
        System.out.println("1.MODIFICAR PRECIO\n");
        System.out.println("2.MODIFICAR STOCK\n");
        System.out.println("3.ELIMINAR PRODUCTO \n");

    }



}

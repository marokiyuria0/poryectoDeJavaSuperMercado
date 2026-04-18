import java.util.Scanner; // Permite leer datos que se ingresen por teclado
// Clase que permite gestionar un producto del inventario
public class MenuGestionar {

    public static void ejecutarGestion() {
        Scanner leer = new Scanner(System.in); //entrada con datos
        String codigoBuscado;
        int indiceProducto;

        System.out.println("====================================");
        System.out.println("MENU PARA GESTIONAR PRODUCTO");
        System.out.println("====================================\n");
        System.out.println("INGRESE CODIGO DE PRODUCTO A BUSCAR");
        System.out.println("PARA SALIR DE ESTE MENU INGRESE 0000\n");

        while (true) { //un bucle para buscar producto
            System.out.print("Codigo: ");
            codigoBuscado = leer.next();
            indiceProducto = -1;

            if ("0000".equals(codigoBuscado)) { // Opción para salir
                return;
            }

            for (int i = 0; i < Inventario.lista.size(); i++) { //busqueda de producto en el inventario
                if (codigoBuscado.equals(Inventario.lista.get(i).getCodigo())) {
                    indiceProducto = i; //se guarda la posicion o el indice del producto que se busca
                    break;
                }
            }

            if (indiceProducto == -1) { // en caso de que no se encuentre se lanzan excepciones personalizadas
                try {
                    throw new ProductoNoEncontradoException("Producto con codigo " + codigoBuscado + " no existe");
                } catch (ProductoNoEncontradoException e) {
                    System.out.println("[ERROR] " + e.getMessage());
                    System.out.println("INGRESE EL CODIGO NUEVAMENTE O PARA SALIR INGRESE 0000\n");
                    continue; //se vuelve a pedir el codigo
                }
            }

            System.out.println("PRODUCTO ENCONTRADO\n");
            break;
        }

        // Mostrar datos del producto
        System.out.println("========== DATOS DEL PRODUCTO ==========");
        System.out.println("NOMBRE: " + Inventario.lista.get(indiceProducto).getNombre());
        System.out.println("PRECIO: $" + Inventario.lista.get(indiceProducto).getPrecio());
        System.out.println("STOCK: " + Inventario.lista.get(indiceProducto).getStock().getCantidadStock());
        System.out.println("ESTADO: " + Inventario.lista.get(indiceProducto).getStock().obtenerEstadoVisual());

        // Menu de gestion
        System.out.println("\n========== GESTION DE PRODUCTO ==========");
        System.out.println("1. MODIFICAR PRECIO");
        System.out.println("2. MODIFICAR PRECIO CON DESCUENTO");
        System.out.println("3. ELIMINAR PRODUCTO");
        System.out.println("4. VOLVER AL MENU PRINCIPAL");
        System.out.print("Opcion: ");

        int opcion = leer.nextInt();

        switch (opcion) {
            case 1: //cambiar precio base del producto
                System.out.print("Nuevo precio: $");
                double nuevoPrecio = leer.nextDouble();
                Inventario.lista.get(indiceProducto).actualizarPrecio(nuevoPrecio);
                System.out.println("Precio actualizado a $" + nuevoPrecio);
                break;

            case 2: //cambiar precio con descuento
                System.out.print("Nuevo precio base: $");
                double precioBase = leer.nextDouble();
                System.out.print("Porcentaje de descuento: ");
                double descuento = leer.nextDouble();
                Inventario.lista.get(indiceProducto).actualizarPrecio(precioBase, descuento);
                System.out.println("Precio final con " + descuento + "% descuento: $" +
                        Inventario.lista.get(indiceProducto).getPrecio());
                break;


            case 3: //eliminar un producto de la lista
                System.out.print("Seguro que desea eliminar el producto? (s/n): ");
                String confirmacion = leer.next();
                if (confirmacion.equalsIgnoreCase("s")) {
                    Producto eliminado = Inventario.lista.remove(indiceProducto);
                    System.out.println("Producto '" + eliminado.getNombre() + "' eliminado");
                } else {
                    System.out.println("Eliminacion cancelada");
                }
                break;

            case 4:
                System.out.println("Volviendo al menu principal...");
                break;

            default:
                System.out.println("Opcion no valida");
        }
    }
}
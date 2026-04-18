import java.util.*;
// Clase que gestiona el inventario, contiene los productos, proveedores y movimientos
public class Inventario {
    // Creacion de HashMap y Arraylist
    public static Map<String, Seccion> secciones = new HashMap<>();
    public static List<Proveedor> proveedores = new ArrayList<>();
    public static ArrayList<Producto> lista = new ArrayList<>();
    public static List<MovimientoStock> movimientos = new ArrayList<>();

    public static Seccion getOrCreateSeccion(String nombreSeccion) { //Se garantiza que la seccion se encuentre en el mapa
        if (!secciones.containsKey(nombreSeccion)) { // si no esta, se crea de desde 0 y se registra
            secciones.put(nombreSeccion, new Seccion(nombreSeccion));
        }
        return secciones.get(nombreSeccion);
    }

    // Agregar producto a una sección
    public static void agregarProducto(String nombreSeccion, Producto p) {
        Seccion s = getOrCreateSeccion(nombreSeccion);
        s.agregarProducto(p);
        lista.add(p); //Se agrega el producto a la lista
        p.setSeccion(nombreSeccion);
    }

    public static void mostrarProductos() {
        for (Producto p : lista) { // se recorre la lista y se muestra producto
            System.out.println(p.mostrarInfo());
            System.out.println("Estado: " + p.getStock().obtenerEstadoVisual());
        }
    }
}

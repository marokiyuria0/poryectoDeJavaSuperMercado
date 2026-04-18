import java.util.*; // Importa todas las clases como listas entre otras
//clase la cual genera e imprime reportes
public class Reporte {

    // Generar reporte de productos por proveedor
    public static void generarReportePorProveedor() {
        System.out.println("\n========== REPORTE POR PROVEEDOR ==========");
        for (Proveedor prov : Inventario.proveedores) { // se recorre la lista de proveedores del inventario
            System.out.println("\n " + prov.getNombre()); // se imprime el nombre del proveedor
            System.out.println("   Productos asociados: " + prov.getListaproducto().size()); // se imprimen los productos asociados al proveedor
        }
    }


    // metodo para tener el reporte de movimiento de stock
    public static void generarReporteMovimientos() {
        System.out.println("\n========== REPORTE DE MOVIMIENTOS DE STOCK ==========");

        if (Inventario.movimientos.isEmpty()) { // verificacion si no hay productos registrados
            System.out.println("No hay movimientos registrados.");
            return; // se sale del metodo si no hay datos
        }

        System.out.println("\nFECHA Y HORA         | TIPO   | PRODUCTO | CANTIDAD | STOCK ANTERIOR → NUEVO");
        System.out.println("--------------------------------------------------------------------------------");

        for (MovimientoStock m : Inventario.movimientos) { //recorre todos los movimientos
            m.imprimirMovimiento();
        }

        // Resumen
        int totalVentas = 0;
        int totalCompras = 0;
        for (MovimientoStock m : Inventario.movimientos) { // recorre nuevamente los movimientos para calcular resumen
            if (m.getTipoMovimiento().equals("VENTA")) { // si el movimiento es una venta se suma la cantidad
                totalVentas += m.getCantidad();
            } else { // si no es venta se asume que es compra y se suma
                totalCompras += m.getCantidad();
            }
        }

        // muestra el resumen de ventas y compras
        System.out.println("\n--- RESUMEN ---");
        System.out.println("Total de ventas: " + totalVentas + " unidades");
        System.out.println("Total de compras: " + totalCompras + " unidades");
    }
}

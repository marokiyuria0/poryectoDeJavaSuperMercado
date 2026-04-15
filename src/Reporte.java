import java.util.*;

public class Reporte {

    // Generar reporte de productos por sección
    public static void generarReportePorSeccion() {
        System.out.println("\n========== REPORTE POR SECCION ==========");

        for (Seccion s : Inventario.secciones.values()) {
            System.out.println("\nSeccion: " + s.getNombre());
            System.out.println("Total productos: " + s.getProductos().size());

            double valorTotal = 0;
            for (Producto p : s.getProductos()) {
                valorTotal += p.getPrecio() * p.getStock().getCantidadStock();
            }

            System.out.println("Valor total inventario: $" + valorTotal);
        }
    }

    // Generar reporte de productos por proveedor
    public static void generarReportePorProveedor() {
        System.out.println("\n========== REPORTE POR PROVEEDOR ==========");

        for (Proveedor prov : Inventario.proveedores) {
            System.out.println("\nProveedor: " + prov.getNombre());
            System.out.println("Cantidad de productos: " + prov.getListaproducto().size());
        }
    }

    // Generar reporte de productos con stock bajo
    public static void generarReporteMovimientoStock() {
        System.out.println("\n========== REPORTE DE STOCK BAJO ==========");

        boolean hayStockBajo = false;

        for (Producto p : Inventario.lista) {
            if (p.getStock().necesitaReposicion()) {
                System.out.println("Producto: " + p.getNombre() + " | Stock actual: " + p.getStock().getCantidadStock() + " | Stock minimo: " + p.getStock().getAlertaBajoStock());
                hayStockBajo = true;
            }
        }

        if (!hayStockBajo) {
            System.out.println("Todos los productos tienen stock suficiente.");
        }
    }
}
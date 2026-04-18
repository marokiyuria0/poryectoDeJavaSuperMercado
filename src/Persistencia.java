import java.io.*;
import java.util.*;

public class Persistencia {
    private static final String ARCHIVO = "inventario.csv";

    // Guardar datos al salir
    public static void guardarDatos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO))) {
            writer.println("TIPO,CODIGO,NOMBRE,PRECIO,STOCK,ALERTA,PROVEEDOR,SECCION");
            for (Producto p : Inventario.lista) {
                writer.printf(Locale.US, "PRODUCTO,%s,%s,%.2f,%d,%d,%s,%s%n",
                        p.getCodigo(), p.getNombre(), p.getPrecio(),
                        p.getStock().getCantidadStock(),
                        p.getStock().getAlertaBajoStock(),
                        p.getProveedor() != null ? p.getProveedor().getNombre() : "SIN PROVEEDOR",
                        p.getSeccion() != null ? p.getSeccion() : "GENERAL");
            }
            System.out.println("Datos guardados en " + ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // Cargar datos al iniciar
    public static void cargarDatos() {
        File file = new File(ARCHIVO);
        if (!file.exists()) {
            System.out.println("Archivo no existe, se creará uno nuevo al guardar.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals("PRODUCTO") && datos.length >= 7) {
                    Stock stock = new Stock(Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), true);
                    Producto p = new Producto(datos[1], datos[2], Double.parseDouble(datos[3]), stock, "N/A");
                    Inventario.lista.add(p);
                }
            }
            System.out.println("Datos cargados desde " + ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
}
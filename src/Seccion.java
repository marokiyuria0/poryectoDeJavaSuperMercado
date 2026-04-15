import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private String nombre;
    private List<Producto> productos;

    public Seccion(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }

    // Métodos para manejar productos
    public void agregarProducto(Producto p) { productos.add(p); }
    public void eliminarProducto(Producto p) { productos.remove(p); }
    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Sección: " + nombre + " | Productos: " + productos.size();
    }
}
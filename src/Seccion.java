import java.util.ArrayList; // se importan array list de listas dinamicas
import java.util.List; // se importan las listas
// Clase que representa una sección o categoría del inventario y permite agrupar productos.
public class Seccion {
    // se crean los atributos para la clase seccion
    private String nombre;
    private List<Producto> productos; // lista de productos que pertenece a la seccion

    // constructor de Seccion
    public Seccion(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>(); // se inicializa la lista vacia y el atributo nombre
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }

    public void agregarProducto(Producto p) { // metodo para agregar un producto a la seccion
        productos.add(p); // se agrega a la seccion
    }
}

public class ClaseProducto {

    private String codigo;
    private String nombre;
    private double precio;
    private stock stock;

    // constructor
    public ClaseProducto(String codigo, String nombre, double precio, stock stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public stock getStock() {
        return stock;
    }

    // setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(stock stock) {
        this.stock = stock;
    }
}
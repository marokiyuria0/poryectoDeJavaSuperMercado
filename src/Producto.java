// clase que representa los productos del sistema, contiene los atributos como precio, stock, etc y sirve como base para crear otros productos

public class Producto {

    // se crean los atributos de la clase
    private String codigo;
    private String nombre;
    private double precio;
    private Stock stocks;
    private String fechaCaducidad;
    private String seccion;
    private Proveedor proveedor;

    // CONSTRUCTOR
    public Producto(String codigo, String nombre, double precio, Stock stocks, String fechaCaducidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stocks = stocks;
        this.fechaCaducidad = fechaCaducidad; // se inicializan los atributos de la clase
    }

    //GETTERS
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Stock getStock() {
        return stocks;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getSeccion() {
        return seccion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    // SETTERS
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(Stock stocks) {
        this.stocks = stocks;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    // SOBRECARGA
    public void actualizarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public void actualizarPrecio(double nuevoPrecio, double descuento) {
        this.precio = nuevoPrecio * (1 - descuento / 100);
    }

    public double calcularPrecioFinal() {
        return this.precio;
    }

    // se muestran los datos del producto
    public String mostrarInfo() {
        return "Codigo: " + codigo + " | Nombre: " + nombre + " | Precio: $" + precio + " | Stock: " +stocks.getCantidadStock();
    }

}
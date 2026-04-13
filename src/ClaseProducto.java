public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private Stock stocks;
    private String fechaCaducidad;

    // constructor
    public Producto(String codigo, String nombre, double precio, Stock stocks, String fechaCaducidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stocks = stocks;
        this.fechaCaducidad = fechaCaducidad;
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

    public Stock getStock() {
        return stocks;
    }

    public String getfechaCaducidad(){ return fechaCaducidad;}

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

    public void setStock(Stock stocks) {
        this.stocks = stocks;
    }

    public void setfechaCaducidad(String fechaCaducidad) {this.fechaCaducidad = fechaCaducidad;}
}
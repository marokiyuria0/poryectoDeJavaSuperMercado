// clase de un producto con descuento que tiene de clase padre Producto y sobrescribe el metodo CalcularPrecioFinal para una rebaja
public class ProductoConDescuento extends Producto { // Clase que hereda de Producto
    private double descuentoFijo;

    // Constructor de la clase
    public ProductoConDescuento(String codigo, String nombre, double precio, Stock stocks, String fechaCaducidad, double descuentoFijo) {
        super(codigo, nombre, precio, stocks, fechaCaducidad); // Llama al constructor de la clase padre (Producto)
        this.descuentoFijo = descuentoFijo; // se inicializa el atributo descuentoFijo
    }

    // sobrescritura del metodo de la clase padre
    @Override
    public double calcularPrecioFinal() {
        return this.getPrecio() * (1 - descuentoFijo / 100); // Calcula el precio final aplicando el descuento porcentual
    }
}
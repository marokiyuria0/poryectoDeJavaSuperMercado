//clase de producto con impuesto agregado que tiene a la clase Producto como padre y usa calcularPrecioFinal para aumentar el precio
public class ProductoConImpuesto extends Producto { // Clase que hereda de Producto
    private double impuestoExtra; //Se crea el atributo de impuesto extra

    public ProductoConImpuesto(String codigo, String nombre, double precio, Stock stocks, String fechaCaducidad, double impuestoExtra) {
        super(codigo, nombre, precio, stocks, fechaCaducidad); // Llama al constructor de la clase padre que es Producto
        this.impuestoExtra = impuestoExtra; // se inicializa el atributo impuestoExtra
    }

    // Dobreescritura del metodo de la clase padre
    @Override
    public double calcularPrecioFinal() {
        return this.getPrecio() * (1 + impuestoExtra / 100); // Calcula el precio final agregando el impuesto porcentual
    }
}

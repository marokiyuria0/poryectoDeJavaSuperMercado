import java.time.LocalDateTime; //el programa usa la hora del dispositivo
import java.time.format.DateTimeFormatter; // ayuda a mejorar el formato de la fecha

// Clase que representa un movimiento de stock. Registra cambios en los productos (ventas o compras), incluyendo cantidad, tipo de movimiento y fecha.
public class MovimientoStock {

    // SE CREAN LOS ATRIBUTOS
    private String codigoProducto;
    private String nombreProducto;
    private String tipoMovimiento;  // "VENTA" o "COMPRA"
    private int cantidad;
    private int stockAnterior;
    private int stockNuevo;
    private String fechaHora;

    // CONSTRUCTOR
    public MovimientoStock(String codigoProducto, String nombreProducto, String tipoMovimiento, int cantidad, int stockAnterior, int stockNuevo) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.stockAnterior = stockAnterior;
        this.stockNuevo = stockNuevo;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // se le pide a java que lo de en un formato especifico
        this.fechaHora = LocalDateTime.now().format(dtf); // Captura el instante actual y lo convierte a texto usando el formato definido
    }

    // Getters
    public String getCodigoProducto() { return codigoProducto; }
    public String getNombreProducto() { return nombreProducto; }
    public String getTipoMovimiento() { return tipoMovimiento; }
    public int getCantidad() { return cantidad; }
    public int getStockAnterior() { return stockAnterior; }
    public int getStockNuevo() { return stockNuevo; }
    public String getFechaHora() { return fechaHora; }

    // se imprime el movimiento que se realizo
    public void imprimirMovimiento(){
        System.out.println(fechaHora + " | " + tipoMovimiento + " | " + nombreProducto + " | Cantidad: " + cantidad + " | Stock: " + stockAnterior +
                " → " + stockNuevo);
    }
}

//excepción que se mostrara cuando no hay stock suficiente
public class StockInsuficienteException extends Exception {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
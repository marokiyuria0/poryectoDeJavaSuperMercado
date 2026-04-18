// Excepción que se lanza cuando no se encuentra un producto
public class ProductoNoEncontradoException extends Exception { // Definición de una excepción personalizada que hereda de Exception
    public ProductoNoEncontradoException(String mensaje) {// Constructor de la excepción
        super(mensaje); // Se llama a la clase padre que es Exception y le pasa un mensaje
    }
}


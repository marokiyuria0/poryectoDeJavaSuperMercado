public class ProductoDeLimpieza extends ClaseProducto {

    private String tipo; // detergente, cloro, desinfectante, etc.
    private int contenido; // en ml
    private boolean esToxico;

    public ProductoDeLimpieza(String codigo, String nombre, double precio, String tipo, int contenido, boolean esToxico){
        super(codigo, nombre, precio);
        this.tipo = tipo;
        this.contenido = contenido;
        this.esToxico = esToxico;
    }

    public String getTipo(){
        return tipo;
    }

    public int getContenido(){
        return contenido;
    }

    public boolean getEsToxico(){
        return esToxico;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setContenido(int contenido){
        this.contenido = contenido;
    }

    public void setEsToxico(boolean esToxico){
        this.esToxico = esToxico;
    }
}
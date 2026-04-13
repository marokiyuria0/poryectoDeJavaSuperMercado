public class ProductoDeLimpieza extends Producto {

    private String tipo;
    private int contenido;
    private boolean esToxico;

    public ProductoDeLimpieza(String codigo, String nombre, double precio, Stock stocks, String fechaCaducidad, String tipo, int contenido, boolean esToxico) {
        super(codigo, nombre, precio, stocks, fechaCaducidad);
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
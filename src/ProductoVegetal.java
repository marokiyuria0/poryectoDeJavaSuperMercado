public class ProductoVegetal extends Producto {

    private String tipo; // fruta o verdura
    private double peso; // en kilos

    public ProductoVegetal(String codigo, String nombre, double precio, Stock stocks,
                           String fechaCaducidad, String tipo, double peso) {
        super(codigo, nombre, precio, stocks, fechaCaducidad);
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getTipo(){
        return tipo;
    }

    public double getPeso(){
        return peso;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }
}
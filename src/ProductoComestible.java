public class ProductoComestible extends Producto {

    private String tipo; // pan, arroz, galletas, pasta, etc.
    private double peso; // en kilos o gramos

    public ProductoComestible(String codigo, String nombre, double precio, Stock stocks,
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
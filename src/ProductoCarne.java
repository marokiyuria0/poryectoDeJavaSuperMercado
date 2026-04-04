public class ProductoCarne extends ClaseProducto {

    private String tipoCarne; // vacuno, pollo, cerdo
    private double peso; // en kilos

    public ProductoCarne(String codigo, String nombre, double precio, String tipoCarne, double peso){
        super(codigo, nombre, precio);
        this.tipoCarne = tipoCarne;
        this.peso = peso;
    }

    public String getTipoCarne(){
        return tipoCarne;
    }

    public double getPeso(){
        return peso;
    }

    public void setTipoCarne(String tipoCarne){
        this.tipoCarne = tipoCarne;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }
}

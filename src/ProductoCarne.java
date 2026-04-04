public class ProductoCarne extends ClaseProducto {

    private String tipoCarne; // vacuno, pollo, cerdo
    private double peso; // en kilos
    private String fechaVencimiento;

    public ProductoCarne(String codigo, String nombre, double precio, String tipoCarne, double peso, String fechaVencimiento){
        super(codigo, nombre, precio);
        this.tipoCarne = tipoCarne;
        this.peso = peso;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipoCarne(){
        return tipoCarne;
    }

    public double getPeso(){
        return peso;
    }

    public String getFechaVencimiento(){
        return fechaVencimiento;
    }

    public void setTipoCarne(String tipoCarne){
        this.tipoCarne = tipoCarne;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setFechaVencimiento(String fechaVencimiento){
        this.fechaVencimiento = fechaVencimiento;
    }
}

public class ProductoVegetal extends ClaseProducto {

    private String tipo; // fruta o verdura
    private double peso; // en kilos
    private String fechaVencimiento;

    public ProductoVegetal(String codigo, String nombre, double precio, String tipo, double peso, String fechaVencimiento){
        super(codigo, nombre, precio);
        this.tipo = tipo;
        this.peso = peso;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipo(){
        return tipo;
    }

    public double getPeso(){
        return peso;
    }

    public String getFechaVencimiento(){
        return fechaVencimiento;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setFechaVencimiento(String fechaVencimiento){
        this.fechaVencimiento = fechaVencimiento;
    }
}
public class ProductoComestible extends ClaseProducto {

    private String tipo; // pan, arroz, galletas, pasta, etc.
    private String fechaVencimiento;
    private double peso; // en kilos o gramos
    private boolean esEnvasado;

    public ProductoComestible(String codigo, String nombre, double precio, String tipo, String fechaVencimiento, double peso, boolean esEnvasado){
        super(codigo, nombre, precio);
        this.tipo = tipo;
        this.fechaVencimiento = fechaVencimiento;
        this.peso = peso;
        this.esEnvasado = esEnvasado;
    }

    public String getTipo(){
        return tipo;
    }

    public String getFechaVencimiento(){
        return fechaVencimiento;
    }

    public double getPeso(){
        return peso;
    }

    public boolean getEsEnvasado(){
        return esEnvasado;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setFechaVencimiento(String fechaVencimiento){
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setEsEnvasado(boolean esEnvasado){
        this.esEnvasado = esEnvasado;
    }
}

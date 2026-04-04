public class ProductoBebestible extends ClaseProducto {

    private int mililitros;
    private boolean esAlcoholico;
    private String fechaVencimiento;

    public ProductoBebestible(String codigo, String nombre, double precio, int mililitros, boolean esAlcoholico, String fechaVencimiento){
        super(codigo, nombre, precio);
        this.mililitros = mililitros;
        this.esAlcoholico = esAlcoholico;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getMililitros(){
        return mililitros;
    }

    public boolean getEsAlcoholico(){
        return esAlcoholico;
    }

    public String getFechaVencimiento(){
        return fechaVencimiento;
    }

    public void setMililitros(int mililitros){
        this.mililitros = mililitros;
    }

    public void setEsAlcoholico(boolean esAlcoholico){
        this.esAlcoholico = esAlcoholico;
    }

    public void setFechaVencimiento(String fechaVencimiento){
        this.fechaVencimiento = fechaVencimiento;
    }
}

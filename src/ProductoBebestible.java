public class ProductoBebestible extends ClaseProducto {

    private int mililitros;
    private boolean esAlcoholico;

    public ProductoBebestible(String codigo, String nombre, double precio, int mililitros, boolean esAlcoholico){
        super(codigo, nombre, precio);
        this.mililitros = mililitros;
        this.esAlcoholico = esAlcoholico;
    }

    public int getMililitros(){
        return mililitros;
    }

    public boolean getEsAlcoholico(){
        return esAlcoholico;
    }

    public void setMililitros(int mililitros){
        this.mililitros = mililitros;
    }

    public void setEsAlcoholico(boolean esAlcoholico){
        this.esAlcoholico = esAlcoholico;
    }
}
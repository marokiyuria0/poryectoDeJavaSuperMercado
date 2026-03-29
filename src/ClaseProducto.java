import java.util.ArrayList;

public class ClaseProducto {
    private String codigo;
    private String nombre;
    private double precio;
    private ArrayList<ClaseProducto> listaProducto;

    //constructor
    public ClaseProducto(String codigo, String nombre, double precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.listaProducto = new ArrayList<>();
    }

    //getters
    public String getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public ArrayList<ClaseProducto> getListaProducto() {
        return listaProducto;
    }

    //setters
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public void setListaProducto(ArrayList<ClaseProducto> listaProducto) {
        this.listaProducto = listaProducto;
    }
}

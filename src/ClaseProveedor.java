import java.util.ArrayList;

public class ClaseProveedor {
    private String rut;
    private String nombre;
    private String numeroTelefono;
    private ArrayList<ClaseProducto> listaproducto; // lista para agregar a producto

    //constructor
    public ClaseProveedor(String rut, String nombre, String numeroTelefono){
        this.rut = rut;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.listaproducto = new ArrayList<>();
    }

    //getters
    public String getRut(){
        return rut;
    }

    public String getNombre(){
        return nombre;
    }

    public String getNumeroTelefono(){
        return numeroTelefono;
    }

    public ArrayList<ClaseProducto> getListaproducto() {
        return listaproducto;
    }

    //setters
    public void setRut(String rut){
        this.rut = rut;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setNumeroTelefono(String numeroTelefono){
        this.numeroTelefono = numeroTelefono;
    }

    public void setListaproducto(ArrayList<ClaseProducto> listaproducto) {
        this.listaproducto = listaproducto;
    }


    //metodos
    public void registrar(){
        System.out.println("Proveedor registrado: "+ nombre + " | rut: "+ rut);
    }

    public void listar(){
        System.out.println("Proveedor registrado: "+ nombre + " | rut: "+ rut + " | numero de telefono: "+ numeroTelefono);
        System.out.println("Productos asociados: "+ listaproducto.size());
    }

    public void asociarProducto(ClaseProducto producto){
        listaproducto.add(producto);
        System.out.println("Producto: "+producto.getNombre() +" asociando al proveedor: "+nombre);
    }

}

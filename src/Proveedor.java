// clase que representa a los proveedores los cuales tienen como atributos rut, nombre, etc. ademas los productos se asocian a este proveedor
import java.util.ArrayList; // Se importan los array list para manejar listas dinamicas

public class Proveedor {
    //Se crean atributos para la clase
    private String rut;
    private String nombre;
    private String numeroTelefono;
    private ArrayList<Producto> listaproducto;

    //Constructor de la clase proveedor
    public Proveedor(String rut, String nombre, String numeroTelefono){
        this.rut = rut;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.listaproducto = new ArrayList<>(); //inicializa la lista vacia de productos y los otros atributos
    }

    //Getters obtener o conseguir los valores
    public String getRut(){
        return rut;
    }

    public String getNombre(){
        return nombre;
    }

    public String getNumeroTelefono(){
        return numeroTelefono;
    }

    public ArrayList<Producto> getListaproducto() {
        return listaproducto;
    }

    //Setters que se usan para modiciar los valores
    public void setRut(String rut){
        this.rut = rut;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setNumeroTelefono(String numeroTelefono){
        this.numeroTelefono = numeroTelefono;
    }

    public void setListaproducto(ArrayList<Producto> listaproducto) {
        this.listaproducto = listaproducto;
    }

    //Metodos

    public void listar(){
        System.out.println("Proveedor registrado: "+ nombre + " | rut: "+ rut + " | numero de telefono: "+ numeroTelefono);  // se imprimen los datos del proveedor
        System.out.println("Productos asociados: "+ listaproducto.size()); // Muestra la cantidad de productos asociados al proveedor
    }

    public void asociarProducto(Producto unProducto){
        listaproducto.add(unProducto); // Se agrega un producto a la lisa
        System.out.println("Producto: "+unProducto.getNombre() +" asociando al proveedor: "+nombre); //Se imprime un mensaje del producto agregado o asociado al proveedor
    }

}

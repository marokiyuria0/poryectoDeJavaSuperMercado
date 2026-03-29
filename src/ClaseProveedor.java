public class ClaseProveedor {
    private String rut;
    private String nombre;
    private String numeroTelefono;

    //constructor
    public ClaseProveedor(String rut, String nombre, String numeroTelefono){
        this.rut = rut;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
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

}

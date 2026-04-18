//clase la cual se tendrán los atributos necesarios para gestionar el stock de cada cosa
public class Stock {
    // Se crean atributos de stock
    private int cantidadStock;
    private int alertaBajoStock;
    private boolean disponibilidad;
    // Contructor de stock
    public Stock(int cantidadStock, int alertaBajoStock, boolean disponibilidad) {
        this.cantidadStock = cantidadStock;
        this.alertaBajoStock = alertaBajoStock;
        this.disponibilidad = disponibilidad;
    }
    //getters y setters de atributos
    public int getCantidadStock() {
        return cantidadStock;
    }

    public int getAlertaBajoStock() {
        return alertaBajoStock;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
        actualizarDisponibilidad();
    }

    public void setAlertaBajoStock(int alertaBajoStock) {
        this.alertaBajoStock = alertaBajoStock;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    private void actualizarDisponibilidad() {
        this.disponibilidad = (this.cantidadStock > 0);
    }

    //SOBRECARGA
    public void modificarStock(int cantidad) { // aumenta el stock
        if (cantidad > 0) {
            this.cantidadStock += cantidad;
            actualizarDisponibilidad();
        }
    }

    //SOBRECARGA
    public boolean modificarStock(int cantidad, String motivo) { // baja stock con motivo del porque se bajo
        int nuevoStock = this.cantidadStock - cantidad;
        if (nuevoStock < 0) {
            return false;
        }
        this.cantidadStock = nuevoStock;
        actualizarDisponibilidad();
        System.out.println("Movimiento: " + motivo);
        return true;
    }

    public boolean necesitaReposicion() {
        return this.cantidadStock <= this.alertaBajoStock;
    }
    public String obtenerEstadoVisual() {
        if (this.cantidadStock == 0) {
            return "AGOTADO";
        } else if (necesitaReposicion()) {
            return "STOCK CRÍTICO";
        } else {
            return "DISPONIBLE";
        }
    }

}
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

    public boolean isDisponibilidad() {
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

    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            this.cantidadStock += cantidad;
            actualizarDisponibilidad();
        }
    }

    public boolean disminuirStock(int cantidad) {
        if (cantidad > 0 && this.cantidadStock >= cantidad) {
            this.cantidadStock -= cantidad;
            actualizarDisponibilidad();
            return true;
        }
        return false;
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

    public String cantidadDisponible() {
        return "LA CANTIDAD QUE QUEDA DEL PRODUCTO ES DE " + cantidadStock;
    }
}
public class Stock {
    protected int cantidadStock;
    protected int alertaBajoStock; //Revisar (protected) para ver cambios hacia private
    protected boolean disponibilidad;

    public Stock(int cantidadStock, int alertaBajoStock, boolean disponibilidad) {
        this.cantidadStock = cantidadStock;
        this.alertaBajoStock = alertaBajoStock;
        this.disponibilidad = disponibilidad;
    }


    public int getCantidadStock() {
        return cantidadStock;
    }

    public int getAlertaBajoStock() {
        return alertaBajoStock;
    }

    public boolean isDisponibilidad() { // Convención 'is' para booleans
        return disponibilidad;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setAlertaBajoStock(int alertaBajoStock) {
        this.alertaBajoStock = alertaBajoStock;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }





    private void actualizarDisponibilidad() {
        this.disponibilidad = (this.cantidadStock > 0); // si es verdadero es que esta disponible aunque podria necesitar reposicion
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
        return this.cantidadStock <= this.alertaBajoStock; // si es true necesita reposicion
    }


    public String obtenerEstadoVisual() {
        if (this.cantidadStock == 0) {
            return "AGOTADO\n";
        } else if (necesitaReposicion()) {
            return "STOCK CRÍTICO\n";
        } else {
            return "DISPONIBLE\n";
        }
    }

    public String cantidadDisponible(){
        return "LA CANTIDAD QUE QUEDA DEL PRODUCTO ES DE\n" +cantidadStock;
    }





}

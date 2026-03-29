public class stock {
    private int cantidadStock;
    private int alertaBajoStock;
    private boolean disponibilidad;

    public stock(int cantidadStock, int alertaBajoStock, boolean disponibilidad) {
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
}

public class Reporte {

    protected int reporteSeccion;
    protected int reporteProveedor;
    protected int reporteMovimStock;

    public Reporte(int reporteSeccion, int reporteProveedor, int reporteMovimStock) {
        this.reporteSeccion = reporteSeccion;
        this.reporteProveedor = reporteProveedor;
        this.reporteMovimStock = reporteMovimStock;
    }

    public int getReporteSeccion() {
        return reporteSeccion;
    }

    public void setReporteSeccion(int reporteSeccion) {
        this.reporteSeccion = reporteSeccion;
    }

    public int getReporteProveedor() {
        return reporteProveedor;
    }

    public void setReporteProveedor(int reporteProveedor) {
        this.reporteProveedor = reporteProveedor;
    }

    public int getReporteMovimStock() {
        return reporteMovimStock;
    }

    public void setReporteMovimStock(int reporteMovimStock) {
        this.reporteMovimStock = reporteMovimStock;
    }


}

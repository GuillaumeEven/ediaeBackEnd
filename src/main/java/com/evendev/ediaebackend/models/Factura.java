public class Factura {

    private int numFactura;
    private int suscripcionId;
    private int cuentaId;
    private double importePvp;
    private String metodoPago;
    private java.sql.Date fechaFactura;

    public Factura(int numFactura, int suscripcionId, int cuentaId, double importePvp, String metodoPago, java.sql.Date fechaFactura) {
        this.numFactura = numFactura;
        this.suscripcionId = suscripcionId;
        this.cuentaId = cuentaId;
        this.importePvp = importePvp;
        this.metodoPago = metodoPago;
        this.fechaFactura = fechaFactura;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public int getSuscripcionId() {
        return suscripcionId;
    }

    public void setSuscripcionId(int suscripcionId) {
        this.suscripcionId = suscripcionId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public double getImportePvp() {
        return importePvp;
    }

    public void setImportePvp(double importePvp) {
        this.importePvp = importePvp;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public java.sql.Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(java.sql.Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    @Override
    public String toString() {
        return "Factura{" + "numFactura=" + numFactura + ", suscripcionId=" + suscripcionId + ", cuentaId=" + cuentaId + ", importePvp=" + importePvp + ", metodoPago=" + metodoPago + ", fechaFactura=" + fechaFactura + '}';
    }

}

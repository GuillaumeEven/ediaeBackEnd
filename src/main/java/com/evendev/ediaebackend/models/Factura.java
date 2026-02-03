package com.evendev.ediaebackend.models;

public class Factura {

    private int num_factura;
    private int suscripcion_id;
    private int cuenta_id;
    private double importe_pvp;
    private String metodo_pago;
    private java.sql.Date fecha_factura;

    public Factura(int num_factura, int suscripcion_id, int cuenta_id, double importe_pvp, String metodo_pago, java.sql.Date fecha_factura) {
        this.num_factura = num_factura;
        this.suscripcion_id = suscripcion_id;
        this.cuenta_id = cuenta_id;
        this.importe_pvp = importe_pvp;
        this.metodo_pago = metodo_pago;
        this.fecha_factura = fecha_factura;
    }

    public int getnum_factura() {
        return num_factura;
    }

    public void setnum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public int getsuscripcion_id() {
        return suscripcion_id;
    }

    public void setsuscripcion_id(int suscripcion_id) {
        this.suscripcion_id = suscripcion_id;
    }

    public int getcuenta_id() {
        return cuenta_id;
    }

    public void setcuenta_id(int cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

    public double getimporte_pvp() {
        return importe_pvp;
    }

    public void setimporte_pvp(double importe_pvp) {
        this.importe_pvp = importe_pvp;
    }

    public String getmetodo_pago() {
        return metodo_pago;
    }

    public void setmetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public java.sql.Date getfecha_factura() {
        return fecha_factura;
    }

    public void setfecha_factura(java.sql.Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    @Override
    public String toString() {
        return "Factura{" + "num_factura=" + num_factura + ", suscripcion_id=" + suscripcion_id + ", cuenta_id=" + cuenta_id + ", importe_pvp=" + importe_pvp + ", metodo_pago=" + metodo_pago + ", fecha_factura=" + fecha_factura + '}';
    }

}

package com.evendev.ediaebackend.models;

public class Suscripcion {

    private int tipoId;
    private String nombre;
    private double precio;
    private int duracionMeses;

    public Suscripcion(int tipoId, String nombre, double precio, int duracionMeses) {
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.precio = precio;
        this.duracionMeses = duracionMeses;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    @Override
    public String toString() {
        return "Suscripcion{" + "tipoId=" + tipoId +
        ", nombre=" + nombre +
        ", precio=" + precio +
        ", duracionMeses=" + duracionMeses +
        '}';
    }
}

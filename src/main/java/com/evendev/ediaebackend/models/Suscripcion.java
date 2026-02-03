package com.evendev.ediaebackend.models;

public class Suscripcion {

    private int tipo_id;
    private String nombre;
    private double precio;
    private int duracion_meses;

    public Suscripcion(int tipo_id, String nombre, double precio, int duracion_meses) {
        this.tipo_id = tipo_id;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion_meses = duracion_meses;
    }

    public int gettipo_id() {
        return tipo_id;
    }

    public void settipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public double getprecio() {
        return precio;
    }

    public void setprecio(double precio) {
        this.precio = precio;
    }

    public int getduracion_meses() {
        return duracion_meses;
    }

    public void setduracion_meses(int duracion_meses) {
        this.duracion_meses = duracion_meses;
    }

    @Override
    public String toString() {
        return "Suscripcion{" + "tipo_id=" + tipo_id +
        ", nombre=" + nombre +
        ", precio=" + precio +
        ", duracion_meses=" + duracion_meses +
        '}';
    }
}

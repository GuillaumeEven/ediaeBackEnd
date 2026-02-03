package com.evendev.ediaebackend.models;

public class Pais {

    private int id;
    private String nombre;

    public Pais(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}

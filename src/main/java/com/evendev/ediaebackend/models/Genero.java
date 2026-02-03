package com.evendev.ediaebackend.models;

public class Genero {
    private int id;
    private String nombre;

    public Genero(int id, String nombre) {
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
        return "Genero{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
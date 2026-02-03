package com.evendev.ediaebackend.models;

public class Reparto {

    private int id_reparto;
    private int id_filmografia;
    private String nombre_actor;
    private String papel;

    public Reparto(int id_reparto, int id_filmografia, String nombre_actor, String papel) {
        this.id_reparto = id_reparto;
        this.id_filmografia = id_filmografia;
        this.nombre_actor = nombre_actor;
        this.papel = papel;
    }

    public int getid_reparto() {
        return id_reparto;
    }

    public void setid_reparto(int id_reparto) {
        this.id_reparto = id_reparto;
    }

    public int getid_filmografia() {
        return id_filmografia;
    }

    public void setid_filmografia(int id_filmografia) {
        this.id_filmografia = id_filmografia;
    }

    public String getnombre_actor() {
        return nombre_actor;
    }

    public void setnombre_actor(String nombre_actor) {
        this.nombre_actor = nombre_actor;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    @Override
    public String toString() {
        return "Reparto{" +
                "id_reparto=" + id_reparto +
                ", id_filmografia=" + id_filmografia +
                ", nombre_actor='" + nombre_actor + '\'' +
                ", papel='" + papel + '\'' +
                '}';
    }

}

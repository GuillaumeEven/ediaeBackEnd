package com.evendev.ediaebackend.models;

public class Reparto {

    private int id_reparto;
    private int idFilmografia;
    private String nombreActor;
    private String papel;

    public Reparto(int idReparto, int idFilmografia, String nombreActor, String papel) {
        this.id_reparto = idReparto;
        this.idFilmografia = idFilmografia;
        this.nombreActor = nombreActor;
        this.papel = papel;
    }

    public int getId_reparto() {
        return id_reparto;
    }

    public void setId_reparto(int idReparto) {
        this.id_reparto = idReparto;
    }

    public int getIdFilmografia() {
        return idFilmografia;
    }

    public void setIdFilmografia(int idFilmografia) {
        this.idFilmografia = idFilmografia;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
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
                "idReparto=" + id_reparto +
                ", idFilmografia=" + idFilmografia +
                ", nombreActor='" + nombreActor + '\'' +
                ", papel='" + papel + '\'' +
                '}';
    }

}

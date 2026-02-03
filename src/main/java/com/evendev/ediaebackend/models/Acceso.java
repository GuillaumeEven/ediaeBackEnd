package com.evendev.ediaebackend.models;

public class Acceso {

    private int idAcceso;
    private int idFilmografia;
    private Integer idCuenta; // Puede ser null
    private java.sql.Timestamp fechaAcceso;
    private Integer tipoSuscripcionId; // Puede ser null

    public Acceso(int idAcceso, int idFilmografia, Integer idCuenta, java.sql.Timestamp fechaAcceso, Integer tipoSuscripcionId) {
        this.idAcceso = idAcceso;
        this.idFilmografia = idFilmografia;
        this.idCuenta = idCuenta;
        this.fechaAcceso = fechaAcceso;
        this.tipoSuscripcionId = tipoSuscripcionId;
    }

    public int getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(int idAcceso) {
        this.idAcceso = idAcceso;
    }

    public int getIdFilmografia() {
        return idFilmografia;
    }

    public void setIdFilmografia(int idFilmografia) {
        this.idFilmografia = idFilmografia;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public java.sql.Timestamp getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(java.sql.Timestamp fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public Integer getTipoSuscripcionId() {
        return tipoSuscripcionId;
    }

    public void setTipoSuscripcionId(Integer tipoSuscripcionId) {
        this.tipoSuscripcionId = tipoSuscripcionId;
    }

    @Override
    public String toString() {
        return "Acceso{" +
        "idAcceso=" + idAcceso +
        ", idFilmografia=" + idFilmografia +
        ", idCuenta=" + idCuenta +
        ", fechaAcceso=" + fechaAcceso +
        ", tipoSuscripcionId=" + tipoSuscripcionId +
        '}';
    }

}

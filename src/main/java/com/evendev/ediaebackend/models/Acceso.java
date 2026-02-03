package com.evendev.ediaebackend.models;

public class Acceso {

    private int id_acceso;
    private int id_filmografia;
    private Integer id_cuenta; // Puede ser null
    private java.sql.Timestamp fecha_acceso;
    private Integer tipo_suscripcion_id; // Puede ser null

    public Acceso(int id_acceso, int id_filmografia, Integer id_cuenta, java.sql.Timestamp fecha_acceso, Integer tipo_suscripcion_id) {
        this.id_acceso = id_acceso;
        this.id_filmografia = id_filmografia;
        this.id_cuenta = id_cuenta;
        this.fecha_acceso = fecha_acceso;
        this.tipo_suscripcion_id = tipo_suscripcion_id;
    }

    public int getid_acceso() {
        return id_acceso;
    }

    public void setid_acceso(int id_acceso) {
        this.id_acceso = id_acceso;
    }

    public int getid_filmografia() {
        return id_filmografia;
    }

    public void setid_filmografia(int id_filmografia) {
        this.id_filmografia = id_filmografia;
    }

    public Integer getid_cuenta() {
        return id_cuenta;
    }

    public void setid_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public java.sql.Timestamp getfecha_acceso() {
        return fecha_acceso;
    }

    public void setfecha_acceso(java.sql.Timestamp fecha_acceso) {
        this.fecha_acceso = fecha_acceso;
    }

    public Integer gettipo_suscripcion_id() {
        return tipo_suscripcion_id;
    }

    public void settipo_suscripcion_id(Integer tipo_suscripcion_id) {
        this.tipo_suscripcion_id = tipo_suscripcion_id;
    }

    @Override
    public String toString() {
        return "Acceso{" +
        "id_acceso=" + id_acceso +
        ", id_filmografia=" + id_filmografia +
        ", id_cuenta=" + id_cuenta +
        ", fecha_acceso=" + fecha_acceso +
        ", tipo_suscripcion_id=" + tipo_suscripcion_id +
        '}';
    }

}

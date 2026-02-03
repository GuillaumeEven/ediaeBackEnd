package com.evendev.ediaebackend.models;

public class Cuenta {

    private int idCuenta;
    private String tipoCuenta;
    private String nombre;
    private String passwordHash;

    public Cuenta(int idCuenta, String tipoCuenta, String nombre, String passwordHash) {
        this.idCuenta = idCuenta;
        this.tipoCuenta = tipoCuenta;
        this.nombre = nombre;
        this.passwordHash = passwordHash;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", tipoCuenta=" + tipoCuenta + ", nombre=" + nombre + ", passwordHash=" + passwordHash + '}';
    }

}

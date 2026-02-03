package com.evendev.ediaebackend.models;

import java.sql.Date;

/**
 *
 * @author sensei
 */
public class Filmografia {
    private int id;
    private String titulo;
    private Date fecha_estreno;
    private String sinopsis;
    private String clasificacion;
    private String pais;

    public Filmografia() {
        super();
    }

    public Filmografia(int id, String titulo, Date fecha_estreno, String sinopsis, String clasificacion, String pais) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_estreno = fecha_estreno;
        this.sinopsis = sinopsis;
        this.clasificacion = clasificacion;
        this.pais = pais;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String gettitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getfecha_estreno() {
        return fecha_estreno;
    }

    public void setfecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public String getsinopsis() {
        return sinopsis;
    }

    public void setsinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getclasificacion() {
        return clasificacion;
    }

    public void setclasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getpais() {
        return pais;
    }

    public void setpais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Filmografia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha_estreno=" + fecha_estreno +
                ", sinopsis='" + sinopsis + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
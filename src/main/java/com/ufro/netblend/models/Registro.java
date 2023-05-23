package com.ufro.netblend.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Registro {
    private Integer id;
    private String correo;
    private Date ultima_conexion;
    private List<Integer> siguiendo;

    public Registro(Integer id, String correo, Date ultima_conexion, List<Integer> siguiendo) {
        this.id = id;
        this.correo = correo;
        this.ultima_conexion = ultima_conexion;
        this.siguiendo = siguiendo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getUltima_conexion() {
        return ultima_conexion;
    }

    public void setUltima_conexion(Date ultima_conexion) {
        this.ultima_conexion = ultima_conexion;
    }

    public List<Integer> getSiguiendo() {
        return siguiendo;
    }

    public void setSiguiendo(List<Integer> siguiendo) {
        this.siguiendo = siguiendo;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMMM/yyyy");
        String fechaUltimaConexion = formatoFecha.format(ultima_conexion);
        return "Registro{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", ultima_conexion=" + fechaUltimaConexion +
                ", siguiendo=" + siguiendo +
                '}';
    }
}
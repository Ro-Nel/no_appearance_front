package com.example.proyectoandroid.model;

import java.sql.Date;
import java.sql.Timestamp;

public class ClienteSubcategoria {

    private int idClienteSubcategoria;
    private int idCliente;
    private int idSubcategoria;

    public ClienteSubcategoria(int idCliente, int idSubcategoria) {
        this.idCliente = idCliente;
        this.idSubcategoria = idSubcategoria;
    }


    public ClienteSubcategoria(int idClienteSubcategoria, int idCliente, int idSubcategoria) {
        this.idClienteSubcategoria = idClienteSubcategoria;
        this.idCliente = idCliente;
        this.idSubcategoria = idSubcategoria;
    }

    public int getIdClienteSubcategoria() {
        return idClienteSubcategoria;
    }

    public void setIdClienteSubcategoria(int idClienteSubcategoria) {
        this.idClienteSubcategoria = idClienteSubcategoria;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }
}


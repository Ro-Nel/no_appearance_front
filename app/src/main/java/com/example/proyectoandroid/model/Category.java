package com.example.proyectoandroid.model;

public class Category {
    private int idCategoria;
    private String categoria;
    private String foto;

    public Category(int idCategoria, String categoria, String foto) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.foto = foto;
    }

    public Category(String categoria) {
        this.categoria = categoria;
    }

    public Category(int idCategoria, String categoria) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
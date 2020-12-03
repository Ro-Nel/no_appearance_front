package com.example.proyectoandroid.model;

public class SubCategory {

    private int idSubcategoria;
    private String subcategoria;
    private String foto;
    private int idCategoria;

    public SubCategory(int idSubcategoria, String subcategoria, String foto, int idCategoria) {
        this.idSubcategoria = idSubcategoria;
        this.subcategoria = subcategoria;
        this.foto = foto;
        this.idCategoria = idCategoria;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}

package com.example.proyectoandroid.model;

public class SubCategory {

    private Integer subcategoryId;
    private Integer categoryId;
    private String name;
    private Integer status;

    public SubCategory(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public SubCategory(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

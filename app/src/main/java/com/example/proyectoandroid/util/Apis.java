package com.example.proyectoandroid.util;

import com.example.proyectoandroid.service.CategoriesService;
import com.example.proyectoandroid.service.SubCategoriesService;
import com.example.proyectoandroid.service.SubCategoriesUserService;
import com.example.proyectoandroid.service.ClienteService;

public class Apis {

    public static final String URL_001="http://192.168.0.13:8083";

    public static CategoriesService getCategoriesService(){
        return Cliente.getCliente(URL_001).create(CategoriesService.class);
    }

    public static SubCategoriesService getSubCategoriesService(int idCategoria){
        return Cliente.getCliente(URL_001+"/"+idCategoria).create(SubCategoriesService.class);
    }


    public static SubCategoriesUserService getSubCategoriesUserService() {
        return Cliente.getCliente(URL_001).create(SubCategoriesUserService.class);

    }

    public static ClienteService clienteService(){
        return Cliente.getCliente(URL_001).create(ClienteService.class);
    }


}
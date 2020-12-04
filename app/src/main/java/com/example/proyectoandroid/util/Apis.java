package com.example.proyectoandroid.util;

import com.example.proyectoandroid.service.*;

public class Apis {

    public static final String URL_001="http://192.168.0.13:8083";

    public static CategoriesService getCategoriesService(){
        return Cliente.getCliente(URL_001).create(CategoriesService.class);
    }

    public static SubCategoriesService getSubCategoriesService(){
        return Cliente.getCliente(URL_001).create(SubCategoriesService.class);
    }

    public static MatchService getMatchService(){
        return Cliente.getCliente(URL_001).create(MatchService.class);
    }

    public static ChatService getChatService(){
        return Cliente.getCliente(URL_001).create(ChatService.class);
    }



    public static SubCategoriesUserService getSubCategoriesUserService() {
        return Cliente.getCliente(URL_001).create(SubCategoriesUserService.class);

    }

    public static ClienteService clienteService(){
        return Cliente.getCliente(URL_001).create(ClienteService.class);
    }


}

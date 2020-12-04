package com.example.proyectoandroid.model;

public class Mensaje {
    private int idMensaje;
    private String mensaje;
    private int idChat;



    public Mensaje( String mensaje, int idChat) {
        this.mensaje = mensaje;
        this.idChat = idChat;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }
}

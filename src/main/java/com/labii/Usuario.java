package com.labii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by umantram on 27/11/16.
 */


public class Usuario {

    private int idUsuario=0;
    private String nombre;
    private String email;

    //private Map<Integer, Calendario> calendarios = new HashMap<Integer, Calendario>();

    public Usuario(int idUsaurio, String nombre, String email) {

        this.idUsuario = idUsaurio;
        this.nombre = nombre;
        this.email = email;
    }

    public Usuario(){

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

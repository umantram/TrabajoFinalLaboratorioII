package com.labii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by umantram on 27/11/16.
 */


/**
 * Esta clase contiene los datos para la creacion de un Usuario
 */

public class Usuario {

    /**
     *Atributos de tipo private para Cumplir con el Encapsulamiento
     *private (Acceso solo dentro de la clase)
     */
    private int idUsuario=0;
    private String nombre;
    private String email;

    /**
     * Contructor Parametrizado
     */
    public Usuario(int idUsaurio, String nombre, String email) {

        this.idUsuario = idUsaurio;
        this.nombre = nombre;
        this.email = email;
    }

    /**
     * Constructor Vacio para el funcionamiento del POST, con SpringBoot
     */
    public Usuario(){

    }

    /**
     *
     Getters y Setter de los Atributos de la Clase
     *
     */
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

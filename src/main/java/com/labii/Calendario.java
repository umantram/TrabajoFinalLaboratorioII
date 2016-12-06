package com.labii;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umantram on 27/11/16.
 */

/**
 * Esta clase contiene los datos para la creacion de un Calendario
*/

public class Calendario {

    /**
     *Atributos de tipo private para Cumplir con el Encapsulamiento
     *private (Acceso solo dentro de la clase)
     */

    private Integer idCalendario = 0;
    private String nombre;
    private Usuario usuario;
    private Integer idUsuario;

    public Calendario(int idCalendario, String nombre, int idUsuario) {

        this.idCalendario = idCalendario;
        this.nombre = nombre;
        this.usuario = UsuarioManejoDatos.getUsuario(idUsuario);

    }

    public Calendario(){

    }

    /**
     *
     Getters y Setter de los Atributos de la Clase
     *
     */

    public Integer getidCalendario() {
        return idCalendario;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

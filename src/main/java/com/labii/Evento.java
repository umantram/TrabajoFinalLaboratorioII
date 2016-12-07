package com.labii;

/**
 * Created by umantram on 27/11/16.
 */

/**
 * Esta clase contiene los datos para la creacion de un Evento
 */

public class Evento {

    /**
     *Atributos de tipo private para Cumplir con el Encapsulamiento
     *private (Acceso solo dentro de la clase)
     */

    private int idEvento;
    private String nombre;
    private String descripcion;
    private Fecha fechaInicio;
    private Fecha fechaFin;
    private String color;
    private int idCalendario;
    private Calendario calendario;

    /**
     * Contructor Parametrizado
     */
    public Evento(int idEvento, String nombre,  String descripcion, String color, Fecha fechaInicio, Fecha fechaFin, int idCalendario) {
        this.idEvento = idEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.calendario = CalendarioManejoDatos.getCalendarioPorID(idCalendario);

        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.color = color;

        this.idCalendario = idCalendario;

        //System.out.println(this.calendario.getNombre());
    }

    /**
     * Constructor Vacio para el funcionamiento del POST, con SpringBoot
     */
    public Evento(){

    }

    /**
     *
     Getters y Setter de los Atributos de la Clase
     *
     */

    public int getIdEvento() {
        return idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdCalendario() {
        return idCalendario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

}

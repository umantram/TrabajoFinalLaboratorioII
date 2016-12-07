package com.labii;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by umantram on 27/11/16.
 */
    @RestController
    public class CalendarioControlador {

    @RequestMapping(value = "/calendario", method = RequestMethod.GET)
    public Collection<Calendario> getCalendario(){
        return CalendarioManejoDatos.getListaCalendarios();
    }

    @RequestMapping(value = "/calendario/{idCalendario}", method = RequestMethod.GET)
    public Calendario getCalendarioPorID(@PathVariable("idCalendario") Integer idCalendario){
        return CalendarioManejoDatos.getCalendario(idCalendario) ;
    }

    //########Muestra todos los Eventos de un Calendario
    @RequestMapping(value = "/calendario/{idCalendario}/evento", method = RequestMethod.GET)
    public Collection<Evento> getEventosPorIDCalendario(@PathVariable("idCalendario") Integer idCalendario){
        return EventoManejoDatos.listaEventosPorIDCalendario(idCalendario) ;
    }

    //Alta
    @RequestMapping(value = "/calendario/alta", method = RequestMethod.POST)
    public void altaCalendario(@RequestBody Calendario input){
        CalendarioManejoDatos.altaCalendario(input.getNombre(), input.getIdUsuario());
    }

    //Baja
    @RequestMapping(value = "/calendario/{idCalendario}/baja", method = RequestMethod.DELETE)
    public void bajaCalendario(@PathVariable(value = "idCalendario") Integer idCalendario){
        CalendarioManejoDatos.bajaCalendario(idCalendario);
    }

    //Modificar
    @RequestMapping(value = "/calendario/{idCalendario}/modificar", method = RequestMethod.PUT)
    public void modificarCalendario(@PathVariable(value = "idCalendario") Integer idCalendario, @RequestBody Calendario Calendario){
        CalendarioManejoDatos.modificarCalendario(idCalendario, Calendario.getNombre());
    }


    //Alta
    @RequestMapping(value = "/calendario/{idCalendario}/altaevento", method = RequestMethod.POST)
    public void altaEventoCalendario(@PathVariable(value = "idCalendario") Integer idCalendario, @RequestBody Evento evento){

        //System.out.println("probando " + evento.getFechaInicio().getDia());

        EventoManejoDatos.altaEvento(evento.getNombre(), evento.getDescripcion(), evento.getColor(),
                evento.getFechaInicio().getDia(), evento.getFechaInicio().getMes(),
                evento.getFechaInicio().getAnio(), evento.getFechaInicio().getHora(),
                evento.getFechaInicio().getMinutos(),
                evento.getFechaFin().getDia(), evento.getFechaFin().getMes(),
                evento.getFechaFin().getAnio(), evento.getFechaFin().getHora(),
                evento.getFechaFin().getMinutos(),
                idCalendario);

    }


}



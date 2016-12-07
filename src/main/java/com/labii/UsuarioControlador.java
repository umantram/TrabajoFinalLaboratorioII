package com.labii;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by francomoglia on 11/30/16.
 */

@RestController
public class UsuarioControlador {

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public Collection<Usuario> getUsuarios(){
        return UsuarioManejoDatos.getUsuarios();
    }

    @RequestMapping(value = "/usuario/{idUsuario}", method = RequestMethod.GET)
    public Usuario getUsuarioPorID(@PathVariable("idUsuario") int idUsuario){
        return UsuarioManejoDatos.getUsuario(idUsuario);
    }

    //Alta Calendario con un Usuario
    @RequestMapping(value = "/usuario/{idUsuario}/altaCalendario", method = RequestMethod.POST)
    public void altaCalendarioUsaurio(@PathVariable("idUsuario") int idUsuario, @RequestBody Calendario calendario){

        CalendarioManejoDatos.altaCalendario(calendario.getNombre(), idUsuario);

    }

    //Alta Eventos de Calendario con un Usuario
    @RequestMapping(value = "/usuario/{idUsuario}/{idCalendario}/altaEvento", method = RequestMethod.POST)
    public void altaEventoCalendarioUsuario(@PathVariable("idCalendario") int idCalendario, @RequestBody Evento evento,
                                            int dia, int mes, int anio, int hora, int minuto, String color){

        //EventoManejoDatos.altaEvento(evento.getNombre(), evento.getDescripcion(), evento.getIdCalendario(), dia,mes,anio,hora,minuto, color);

    }

    //Alta
    @RequestMapping(value = "/usuario/alta", method = RequestMethod.POST)
    public void altaUsuario(@RequestBody Usuario input){

        UsuarioManejoDatos.altaUsuario(input.getNombre(), input.getEmail());
        //return HttpStatus.OK;

    }

    @RequestMapping(value = "/usuario/{idUsuario}/baja", method = RequestMethod.DELETE)
    public void bajaUsuario(@PathVariable(value = "idUsuario") Integer idUsuario){
        UsuarioManejoDatos.bajaUsuario(idUsuario);
    }

    @RequestMapping(value = "/usuario/{idUsuario}/modificar", method = RequestMethod.PUT)
    public void modifUsuario(@PathVariable(value = "idUsuario") Integer idUsuario, @RequestBody Usuario usuario){
        UsuarioManejoDatos.modifUsuario(idUsuario, usuario.getEmail());
    }

    /**
    @RequestMapping(value = "/usuarios/filtro", method = RequestMethod.GET)
    public Collection<Usuario> getPorEmail(@RequestParam(value = "email", defaultValue = "all") String email){
        if (email.equals("all")){
            return UsuarioManejoDatos.getUsuarios();
        }else {
            Collection result = new ArrayList();
            for (Usuario aux : UsuarioManejoDatos.getUsuarios()){
                if (aux.getEmail().equals(email)){
                    result.add(aux);
                }
            }

            return result;
        }
    }
    */

}
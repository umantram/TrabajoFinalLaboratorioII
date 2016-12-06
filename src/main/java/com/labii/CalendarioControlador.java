package com.labii;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by umantram on 27/11/16.
 */

    /*
    *   En el enfoque de Spring para la creación de servicios web RESTful,
    *   las solicitudes HTTP son manejadas por un controlador. Estos componentes se identifican f
    *   ácilmente mediante la anotación @RestController
    */
    @RestController
    public class CalendarioControlador {

    /**
     * GET
     * Recuperar la información. Las solicitudes GET deben ser seguras e idempotentes, es decir,
     * independientemente de cuántas veces se repitan con los mismos parámetros,
     * los resultados son los mismos. Pueden tener efectos secundarios,
     * pero el usuario no los espera, por lo que no pueden ser críticos para el funcionamiento del sistema.
     * Las solicitudes también pueden ser parciales o condicionales.
     */

    /**
     *La anotación @RequestMapping asegura que las peticiones HTTP/calendario están asignadas al método getCalendario().
     * Llama al Metodo getListaCalendarios() que esta dentro de la Clase CalendarioManejoDatos.
     * Este metodo devuelve una Collection de Calendarios.
     */
    @RequestMapping(value = "/calendario", method = RequestMethod.GET)
    public Collection<Calendario> getCalendario(){
        return CalendarioManejoDatos.getListaCalendario();
    }

    /**
     *La anotación @RequestMapping asegura que las peticiones HTTP/calendario/{idCalendario} están asignadas
     * al método getCalendarioPorID().
     *
     * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idCalendario
     *
     * Llama al Metodo getCalendarioPorID() que nesecita como parametro idCalendario,
     * que se encuentra dentro de la Clase CalendarioManejoDatos.
     *
     * Este metodo devuelve un Calendario.
     */
    @RequestMapping(value = "/calendario/{idCalendario}", method = RequestMethod.GET)
    public Calendario getCalendarioPorID(@PathVariable("idCalendario") Integer idCalendario){
        return CalendarioManejoDatos.getCalendarioPorID(idCalendario) ;
    }

    /**
     *La anotación @RequestMapping asegura que las peticiones HTTP/calendario/{idCalendario}/evento están asignadas
     * al método getEventosPorIDCalendario().
     *
     * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idCalendario
     *
     * Llama al Metodo listaEventosPorIDCalendario() que nesecita como parametro idCalendario,
     * que se encuentra dentro de la Clase EventoManejoDatos.
     *
     * Este metodo devuelve una Collection de Eventos.
     */
    @RequestMapping(value = "/calendario/{idCalendario}/evento", method = RequestMethod.GET)
    public Collection<Evento> getEventosPorIDCalendario(@PathVariable("idCalendario") Integer idCalendario){
        return EventoManejoDatos.listaEventosPorIDCalendario(idCalendario) ;
    }

    /**
     * POST
     * Solicitar que el recurso en el URI haga algo con la entidad proporcionada.
     * A menudo, POST se utiliza para crear una nueva entidad, pero también se puede utilizar para actualizar una entidad.
     */

    /**
     * La anotación @RequestMapping asegura que las peticiones HTTP/calendario/alta están asignadas
     * al método altaCalendario().
     *
     * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
     * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Calendario
     *
     * Llama al Metodo altaCalendario() que se encuentra dentro de la Clase CalendarioManejoDatos.
     */

    @RequestMapping(value = "/calendario/alta", method = RequestMethod.POST)
    public void altaCalendario(@RequestBody Calendario input){
        CalendarioManejoDatos.altaCalendario(input.getNombre(), input.getIdUsuario());
    }

    /**
     * La anotación @RequestMapping asegura que las peticiones HTTP/calendario/{idCalendario}/altaevento están asignadas
     * al método altaEventoCalendario().
     *
     * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idCalendario
     *
     * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
     * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Evento
     *
     * Llama al Metodo altaEvento() que se encuentra dentro de la Clase Evento ManejoDatos.
     */

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

    /**
     * DELETE
     *
     * Solicitar que se elimine un recurso; Sin embargo, el recurso no tiene que quitarse inmediatamente.
     * Podría ser una solicitud asincrónica o de larga duración.
     */

    /**
     * La anotación @RequestMapping asegura que las peticiones HTTP/calendario/{idCalendario}/baja están asignadas
     * al método bajaCalendario().
     *
     * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idCalendario
     *
     * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
     * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Calendario
     *
     * Llama al Metodo bajaCalendario() que se encuentra dentro de la Clase CalendarioManejoDatos.
     */

    @RequestMapping(value = "/calendario/{idCalendario}/baja", method = RequestMethod.DELETE)
    public void bajaCalendario(@PathVariable(value = "idCalendario") Integer idCalendario){
        CalendarioManejoDatos.bajaCalendario(idCalendario);
    }

    /**
     * PUT
     *
     * Almacene una entidad en un URI. PUT puede crear una nueva entidad o actualizar una existente.
     * Una solicitud PUT es idempotent. Idempotencia es la principal diferencia entre las expectativas de PUT
     * versus una solicitud POST.
     *
     */

    /**
     * La anotación @RequestMapping asegura que las peticiones HTTP/calendario/{idCalendario}/modificar están asignadas
     * al método modificarCalendario().
     *
     * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idCalendario
     * 
     * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
     * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Calendario
     *
     * Llama al Metodo bajaCalendario() que se encuentra dentro de la Clase CalendarioManejoDatos.
     */

    @RequestMapping(value = "/calendario/{idCalendario}/modificar", method = RequestMethod.PUT)
    public void modificarCalendario(@PathVariable(value = "idCalendario") Integer idCalendario, @RequestBody Calendario Calendario){
        CalendarioManejoDatos.modificarCalendario(idCalendario, Calendario.getNombre());
    }





}



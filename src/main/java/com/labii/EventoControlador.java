package com.labii;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by umantram on 28/11/16.
 */

 /*
    *   En el enfoque de Spring para la creación de servicios web RESTful,
    *   las solicitudes HTTP son manejadas por un controlador. Estos componentes se identifican
    *   fácilmente mediante la anotación @RestController
 */
@RestController
public class EventoControlador {


    /**
     * GET
     * Recuperar la información. Las solicitudes GET deben ser seguras e idempotentes, es decir,
     * independientemente de cuántas veces se repitan con los mismos parámetros,
     * los resultados son los mismos. Pueden tener efectos secundarios,
     * pero el usuario no los espera, por lo que no pueden ser críticos para el funcionamiento del sistema.
     * Las solicitudes también pueden ser parciales o condicionales.
     */

    /**
     *La anotación @RequestMapping asegura que las peticiones HTTP/evento están asignadas al método getEvento().
     * Llama al Metodo getListaEventos() que esta dentro de la Clase EventoManejoDatos.
     * Este metodo devuelve una Collection de Calendarios.
     */
    @RequestMapping(value = "/evento", method = RequestMethod.GET)
    public Collection<Evento> getEvento(){
        return EventoManejoDatos.getListaEventos();
    }

    /**
     *La anotación @RequestMapping asegura que las peticiones HTTP/evento/listadoFecha están asignadas
     * al método getEventoFecha().
     *
     * anotación @RequestParam anotación utilizada para acceder a los valores de los parámetros de
     * consulta de la solicitud, fecha
     *
     * Llama al Metodo listaEventosPorFecha() que nesecita como parametro fecha,
     * que se encuentra dentro de la Clase EventoManejoDatos.
     *
     * Este metodo devuelve una Collection de Eventos.
     */
    @RequestMapping(value = "/evento/listadofecha", method = RequestMethod.GET, params={"fecha"})
    public Collection<Evento> getEventoFecha(@RequestParam("fecha") String fecha ) throws ParseException {

        return EventoManejoDatos.listaEventosPorFecha(fecha);
    }

    /**
     *La anotación @RequestMapping asegura que las peticiones HTTP/evento/listadoFecha están asignadas
     * al método getEventoFechaDesdeHasta().
     *
     * anotación @RequestParam anotación utilizada para acceder a los valores de los parámetros de
     * consulta de la solicitud, fechadesde y fechahasta
     *
     * Llama al Metodo listaEventosPorFechaDesdeHasta() que nesecita como parametro fechadesde y fechahasta,
     * que se encuentra dentro de la Clase EventoManejoDatos.
     *
     * Este metodo devuelve una Collection de Eventos.
     */
    @RequestMapping(value = "/evento/listadofecha", method = RequestMethod.GET, params={"fechadesde", "fechahasta"})
    public Collection<Evento> getEventoFechaDesdeHasta(@RequestParam("fechadesde") String fechaDesde,
                                                       @RequestParam("fechahasta") String fechaHasta ) throws ParseException {

        return EventoManejoDatos.listaEventosPorFechaDesdeHasta(fechaDesde, fechaHasta);
    }

    /**
     *La anotación @RequestMapping asegura que las peticiones HTTP/evento/{idCalendario} están asignadas
     * al método getEventoPorID().
     *
     * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idEvento
     *
     * Llama al Metodo getEventoPorID() que nesecita como parametro idEvento,
     * que se encuentra dentro de la Clase EventoManejoDatos.
     *
     * Este metodo devuelve un Evento.
     */
    @RequestMapping(value = "/evento/{idEvento}", method = RequestMethod.GET)
    public Evento getEventoPorID(@PathVariable("idEvento") Integer idEvento){
        return EventoManejoDatos.getEventos(idEvento) ;
    }


    /**
     * POST
     * Solicitar que el recurso en el URI haga algo con la entidad proporcionada.
     * A menudo, POST se utiliza para crear una nueva entidad, pero también se puede utilizar para actualizar una entidad.
     */

    /**
     * La anotación @RequestMapping asegura que las peticiones HTTP/evento/alta están asignadas
     * al método altaEvento().
     *
     * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
     * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Evento
     *
     * Llama al Metodo altaEvento() que se encuentra dentro de la Clase EventoManejoDatos.
     */
    @RequestMapping(value = "/evento/alta", method = RequestMethod.POST)
    public void altaEvento(@RequestBody Evento evento){

        EventoManejoDatos.altaEvento(evento.getNombre(), evento.getDescripcion(), evento.getColor(),
                                evento.getFechaInicio().getDia(), evento.getFechaInicio().getMes(),
                                evento.getFechaInicio().getAnio(), evento.getFechaInicio().getHora(),
                                evento.getFechaInicio().getMinutos(),
                                evento.getFechaFin() .getDia(), evento.getFechaFin().getMes(),
                                evento.getFechaFin().getAnio(), evento.getFechaFin().getHora(),
                                evento.getFechaFin().getMinutos(),
                                evento.getIdCalendario());

    }

    /**
     * DELETE
     *
     * Solicitar que se elimine un recurso; Sin embargo, el recurso no tiene que quitarse inmediatamente.
     * Podría ser una solicitud asincrónica o de larga duración.
     */

    /**
     * La anotación @RequestMapping asegura que las peticiones HTTP/evento/{idEvento}/baja están asignadas
     * al método bajaCalendario().
     *
     * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idEvento
     *
     * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
     * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Evento
     *
     * Llama al Metodo bajaEvento() que se encuentra dentro de la Clase EventoManejoDatos.
     */
    @RequestMapping(value = "/evento/{idEvento}/baja", method = RequestMethod.DELETE)
    public void bajaEvento(@PathVariable(value = "idEvento") Integer idEvento){

        EventoManejoDatos.bajaEvento(idEvento);
    }

    /**
     * PUT
     *
     * PUT puede crear una nueva entidad o actualizar una existente.
     * Una solicitud PUT es idempotent. Idempotencia es la principal diferencia entre las expectativas de PUT
     * versus una solicitud POST.
     *
     */

    /**
     * La anotación @RequestMapping asegura que las peticiones HTTP/evento/{idEvento}/modificar están asignadas
     * al método modificarEvento().
     *
     * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idEvento
     *
     * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
     * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Evento.
     *
     * Llama al Metodo modificarEvento() que se encuentra dentro de la Clase EventoManejoDatos.
     */
    @RequestMapping(value = "/evento/{idEvento}/modificar", method = RequestMethod.PUT)
    public void modificarEvento(@PathVariable(value = "idEvento") Integer idEvento, @RequestBody Evento evento){
        EventoManejoDatos.modificarEvento(idEvento, evento.getNombre(), evento.getDescripcion());
    }

}

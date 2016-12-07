package com.labii;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by umantram on 11/30/16.
 */

    /**
    *   En el enfoque de Spring para la creación de servicios web RESTful,
    *   las solicitudes HTTP son manejadas por un controlador. Estos componentes se identifican f
    *   ácilmente mediante la anotación @RestController
    */
@RestController
public class UsuarioControlador {


        /**
         * GET
         * Recuperar la información. Las solicitudes GET deben ser seguras e idempotentes, es decir,
         * independientemente de cuántas veces se repitan con los mismos parámetros,
         * los resultados son los mismos. Pueden tener efectos secundarios,
         * pero el usuario no los espera, por lo que no pueden ser críticos para el funcionamiento del sistema.
         * Las solicitudes también pueden ser parciales o condicionales.
         */

        /**
        * La anotación @RequestMapping asegura que las peticiones HTTP/usuario están asignadas al método getUsaurio().
        * Llama al Metodo getListaUsuario() que esta dentro de la Clase usuarioManejoDatos.
        * Este metodo devuelve una Collection de Usuarios.
        */
        @RequestMapping(value = "/usuario", method = RequestMethod.GET)
        public Collection<Usuario> getUsuario(){
            return UsuarioManejoDatos.getListaUsuario();
        }

        /**
         *La anotación @RequestMapping asegura que las peticiones HTTP/usuario/{idUsuario} están asignadas
         * al método getUsuarioPorID().
         *
         * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idUsuario
         *
         * Llama al Metodo getUsuario() que nesecita como parametro idUsuario,
         * que se encuentra dentro de la Clase UsaurioManejoDatos.
         *
         * Este metodo devuelve un Usuario.
         */
        @RequestMapping(value = "/usuario/{idUsuario}", method = RequestMethod.GET)
        public Usuario getUsuarioPorID(@PathVariable("idUsuario") int idUsuario){
            return UsuarioManejoDatos.getUsuario(idUsuario);
        }

        /**
        * La anotación @RequestMapping asegura que las peticiones HTTP/usuario/{idUsuario}/calendario están asignadas
        * al método getUsuarioPorID().
        *
        * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idUsuario
        *
        * Llama al Metodo listaCalendariosPorIdUsuario() que nesecita como parametro idUsuario,
        * que se encuentra dentro de la Clase CalendarioManejoDatos.
        *
         * Este metodo devuelve una Collection de Calendario.
        */
        @RequestMapping(value = "/usuario/{idUsuario}/calendario", method = RequestMethod.GET)
        public Collection<Calendario> getUsuarioCalendarioPorID(@PathVariable("idUsuario") int idUsuario){
            return CalendarioManejoDatos.listaCalendariosPorIdUsuario(idUsuario);
        }

        /**
        * La anotación @RequestMapping asegura que las peticiones HTTP/usuario/{idUsuario}/{idCalendario}/evento están asignadas
        * al método getEventosPorIDCalendario().
        *
        * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idCalendario
        *
        * Llama al Metodo listaEventosPorIDCalendario() que nesecita como parametro idCalendario,
        * que se encuentra dentro de la Clase EventoManejoDatos.
        *
        * Este metodo devuelve una Collection de Evento.
        */
        @RequestMapping(value = "/usuario/{idUsuario}/{idCalendario}/evento", method = RequestMethod.GET)
        public Collection<Evento> getEventosPorIDCalendario(@PathVariable("idCalendario") Integer idCalendario){
            return EventoManejoDatos.listaEventosPorIDCalendario(idCalendario) ;
        }
        /**
         * POST
         * Solicitar que el recurso en el URI haga algo con la entidad proporcionada.
         * A menudo, POST se utiliza para crear una nueva entidad, pero también se puede utilizar para actualizar una entidad.
         */

        /**
         * La anotación @RequestMapping asegura que las peticiones HTTP/usuario/alta están asignadas
         * al método altaUsuario().
         *
         * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
         * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Usaurio
         *
         * Llama al Metodo altaUsaurio() que se encuentra dentro de la Clase UsuarioManejoDatos.
         */
        @RequestMapping(value = "/usuario/alta", method = RequestMethod.POST)
        public void altaUsuario(@RequestBody Usuario input){

            UsuarioManejoDatos.altaUsuario(input.getNombre(), input.getEmail());

        }

        /**
         * La anotación @RequestMapping asegura que las peticiones HTTP/usuario/{idUsuario}/altaCalendario están asignadas
         * al método altaCalendarioUsaurio().
         *
         * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idUsuario
         *
         * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
         * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Calendario
         *
         * Llama al Metodo altaCalendario() que se encuentra dentro de la Clase CalendarioManejoDatos.
         */
        @RequestMapping(value = "/usuario/{idUsuario}/altacalendario", method = RequestMethod.POST)
        public void altaCalendarioUsaurio(@PathVariable("idUsuario") int idUsuario, @RequestBody Calendario calendario){

            CalendarioManejoDatos.altaCalendario(calendario.getNombre(), idUsuario);

        }

        /**
         * La anotación @RequestMapping asegura que las peticiones HTTP/usuario/{idUsuario}/{idCalendario}/altaEvento
         * están asignadas al método altaEventoCalendarioUsuario().
         *
         * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante,
         * idUsuario, idCalendario
         *
         * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
         * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Evento
         *
         * Llama al Metodo altaEvento() que se encuentra dentro de la Clase EventoManejoDatos.
         */

        @RequestMapping(value = "/usuario/{idUsuario}/{idCalendario}/altaevento", method = RequestMethod.POST)
        public void altaEventoCalendarioUsuario(@PathVariable("idCalendario") int idCalendario,
                                                @PathVariable("idUsuario") int idUsario,
                                                @RequestBody Evento evento){

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
         * La anotación @RequestMapping asegura que las peticiones HTTP/usuario/{idUsuario}/baja están asignadas
         * al método bajaCalendario().
         *
         * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idUsuario
         *
         * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
         * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Usuario
         *
         * Llama al Metodo bajaUsuario() que se encuentra dentro de la Clase UsuarioManejoDatos.
         */
        @RequestMapping(value = "/usuario/{idUsuario}/baja", method = RequestMethod.DELETE)
        public void bajaUsuario(@PathVariable(value = "idUsuario") Integer idUsuario){
            UsuarioManejoDatos.bajaUsuario(idUsuario);
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
         * La anotación @RequestMapping asegura que las peticiones HTTP/usuario/{idUsuario}/modificar están asignadas
         * al método modificarUsuario().
         *
         * La anotacion @PathVariable identifica el patrón que se utiliza en el URI para la solicitud entrante, idUsuario
         *
         * La anotación del parámetro del método @RequestBody debe enlazar el valor json en el cuerpo de la
         * petición HTTP al objeto java usando un HttpMessageConverter, En este caso la Clase Usuario.
         *
         * Llama al Metodo modificarUsuario() que se encuentra dentro de la Clase UsuarioManejoDatos.
         */
        @RequestMapping(value = "/usuario/{idUsuario}/modificar", method = RequestMethod.PUT)
        public void modificarUsuario(@PathVariable(value = "idUsuario") Integer idUsuario, @RequestBody Usuario usuario){
            UsuarioManejoDatos.modificarUsuario(idUsuario, usuario.getEmail());
        }

    }
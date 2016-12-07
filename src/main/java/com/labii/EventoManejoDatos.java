package com.labii;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import Exception.CustomExceptionUsuario;

/**
 * Created by umantram on 27/11/16.
 */
public class EventoManejoDatos {

    /**
     * listaEventos, es un HashMap que guarda los objetos de tipo Evento, el cual se lo utiliza como
     * Base de datos, para los AMB(alta, baja, modificar)
     */
    private static final Map<Integer, Evento> listaEventos = new HashMap<Integer, Evento>();

    /**
     * AtomicInteger
     *
     * Un valor int que puede actualizarse atómicamente.
     * Un AtomicInteger se utiliza en aplicaciones tales como contadores con incremento atómico
     * y no se puede utilizar como un reemplazo para un entero.
     */
    private static final AtomicInteger contador = new AtomicInteger(0);

    /**
     * Se crean Instancias iniciales para poder ver el funcionamiento.
     * Estos objetos creados que cargan al HashMap listaCalendarios
     */
    static {

        Evento evento1 = new Evento(contador.incrementAndGet(), "limpiar" , "Tengo que limpiar mi Pieza", "Rojo",
                         new Fecha(10,01,2016,20,30), new Fecha(10,01,2016,21,30),1);
        //Evento evento2 = new Evento(contador.incrementAndGet(), "Estudiar", "Tengo que estudiar para Lab", "Verde",
        //                 new Fecha(15,01,2016,15,30), new Fecha(15,01,2016,16,30), 1);

        //Evento evento3 = new Evento(contador.incrementAndGet(), "trabajar",2, "Tengo que terminar mi desarrollo de la Api",
        //                 new Fecha(9,1,2016,3,30), new Fecha(9,1,2016,4,30), "Azul");

        listaEventos.put(evento1.getIdEvento(), evento1);
        //listaEventos.put(evento2.getIdEvento(), evento2);
        //listaEventos.put(evento3.getIdEvento(), evento3);

    }

    /**
     * Metodo que devuelve una Collection de Eventos.
    */
    public static Collection<Evento> getListaEventos() {
        return listaEventos.values();
    }

    /**
     * Metodo que devuelve un Obejeto Evento que corresponda al idEvento que se le pasa como Parametro.
     */
    public static Evento getEventos(Integer idEventos) {
        return listaEventos.get(idEventos);
    }

    /**
     * Metodo que devuelve una Collection de Eventos que corresponda al idCalendario que se le pasa como Parametro.
     */
    public static Collection<Evento> listaEventosPorIDCalendario(Integer idCalendario){

        HashMap<Integer, Evento> resul = new HashMap<Integer, Evento>();

        for (Evento list : listaEventos.values()){

            if (list.getCalendario().getidCalendario() == idCalendario){
                resul.put(list.getIdEvento(), list);
            }
        }

        return resul.values();
    }

    /**
     * Metodo que devuelve una Collection de Eventos,
     * donde la fecha de cada evento sea igual a fechaBusqueda que se le pasa como Parametro.
     * ParseException: Indica que se ha producido un error inesperado durante el análisis.
     */
    public static Collection<Evento> listaEventosPorFecha(String fechaBusqueda) throws ParseException {

        /**
         * Convierte la fecha que se pasa por parametro que es un String a Date mediante formatter,
         * Con un foreach se recorre la lista de eventos, y por cada objeto, se toma la fecha y se le da el mismo
         * formato que la fechaBusqueda para asi comparar y devolver una Colletion de eventos.
         * Se utiliza la fecha de Inicio de cada Evento
         */
        HashMap<Integer, Evento> resul = new HashMap<Integer, Evento>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date dateClase;
        String dateInStringClase;

        try {

            Date dateBusqueda = formatter.parse(fechaBusqueda);

        for (Evento list : listaEventos.values()){

            dateInStringClase = list.getFechaInicio().getDia() +"/"+ list.getFechaInicio().getMes() +"/"+ list.getFechaInicio().getAnio();
            dateClase = formatter.parse(dateInStringClase);

            if (dateBusqueda.equals(dateClase) ){
                resul.put(list.getIdEvento(), list);
            }

        }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resul.values();

    }

    /**
     * Metodo que devuelve una Collection de Eventos,
     * donde la fecha de cada evento se encuetre entre la fechaDesde y fechaHasta que se le pasa como Parametro.
     * ParseException: Indica que se ha producido un error inesperado durante el análisis.
     */
    public static Collection<Evento> listaEventosPorFechaDesdeHasta(String fechaDesde, String fechaHasta) throws ParseException {

        /**
        * Convierte la fecha que se pasa por parametro que es un String a Date mediante formatter,
        * Con un foreach se recorre la lista de eventos, y por cada objeto, se toma la fecha y se le da el mismo
        * formato que la fechaBusqueda para asi comparar y devolver una Colletion de eventos.
        * Se utiliza la fecha de Inicio de cada Evento
         * Este metodo busca la fecha que este dentro del Rango fechaDesde y fechaHasta
        */
        HashMap<Integer, Evento> resul = new HashMap<Integer, Evento>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date dateClase;
        String dateInStringClase;

        try {

            Date dateClaseDesde = formatter.parse(fechaDesde);
            Date dateClaseHasta = formatter.parse(fechaHasta);

            for (Evento list : listaEventos.values()){

                dateInStringClase = list.getFechaInicio().getDia() +"/"+ list.getFechaInicio().getMes() +"/"+ list.getFechaInicio().getAnio();
                dateClase = formatter.parse(dateInStringClase);

                if (dateClaseDesde.before(dateClase) && dateClaseHasta.after(dateClase)){

                    resul.put(list.getIdEvento(), list);
                }

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resul.values();

    }

    /**
     * Metodo que genera una nueva Instancia de Evento, y lo agrega al hashMap
     * los datos que se le pasa por parametros son los Atributos de la Clase.
     */
    public static void altaEvento(String nombre, String descripcion, String color,
                                  Integer diaInicio, Integer mesInicio, Integer anioInicio, Integer horaInicio, Integer minutoInicio,
                                  Integer diaFin, Integer mesFin, Integer anioFin, Integer horaFin, Integer minutoFin,
                                  Integer idCalendario){

        Evento evento = new Evento(contador.incrementAndGet(), nombre, descripcion, color,
                        new Fecha(diaInicio,mesInicio,anioInicio,horaInicio,minutoInicio),
                        new Fecha(diaFin,mesFin,anioFin,horaFin,minutoFin), idCalendario);

        listaEventos.put(evento.getIdEvento(), evento);

    }

    /**
     * Metodo que elimina un registro del hashMap
     * @param idEvento
     */
    public static void bajaEvento(int idEvento){

        listaEventos.remove(idEvento);

    }

    /**
     * Metodo que modifica un registro del hashMap, que correspnda al idCalendario, y el nuevo valor a asignar
     * @param idEvento
     * @param nombre
     * @param descripcion
     */
    public static void modificarEvento(int idEvento, String nombre, String descripcion){

        if (listaEventos.get(idEvento) != null) {

            if (listaEventos.get(idEvento) != null) listaEventos.get(idEvento).setNombre(nombre);
            if (listaEventos.get(idEvento) != null) listaEventos.get(idEvento).setDescripcion(descripcion);

        }else throw new CustomExceptionUsuario("Evento no encontrado");

    }

}

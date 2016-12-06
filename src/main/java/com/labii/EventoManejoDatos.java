package com.labii;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by umantram on 27/11/16.
 */
public class EventoManejoDatos {

    private static final Map<Integer, Evento> listaEventos = new HashMap<Integer, Evento>();
    private static final AtomicInteger contador = new AtomicInteger(0);

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

    public static Collection<Evento> getListaEventos() {
        return listaEventos.values();
    }

    public static Evento getEventos(Integer idEventos) {
        return listaEventos.get(idEventos);
    }

    //Muestra todos los Eventos de un Calendario
    public static Collection<Evento> listaEventosPorIDCalendario(Integer idCalendario){

        HashMap<Integer, Evento> resul = new HashMap<Integer, Evento>();

        for (Evento list : listaEventos.values()){

            if (list.getCalendario().getidCalendario() == idCalendario){
                resul.put(list.getIdEvento(), list);
            }
        }

        return resul.values();
    }

    //Muestra todos los Eventos de un Calendario por fecha
    public static Collection<Evento> listaEventosPorFecha(String fechaBusqueda) throws ParseException {

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

    //Muestra todos los Eventos de un Calendario por fecha
    public static Collection<Evento> listaEventosPorFechaDesdeHasta(String fechaDesde, String fechaHasta) throws ParseException {

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

    //  ALTA
    public static void altaEvento(String nombre, String descripcion, String color,
                                  Integer diaInicio, Integer mesInicio, Integer anioInicio, Integer horaInicio, Integer minutoInicio,
                                  Integer diaFin, Integer mesFin, Integer anioFin, Integer horaFin, Integer minutoFin,
                                  Integer idCalendario){

        Evento evento = new Evento(contador.incrementAndGet(), nombre, descripcion, color,
                        new Fecha(diaInicio,mesInicio,anioInicio,horaInicio,minutoInicio),
                        new Fecha(diaFin,mesFin,anioFin,horaFin,minutoFin), idCalendario);

        listaEventos.put(evento.getIdEvento(), evento);

    }

    // BAJA
    public static void bajaEvento(int idEvento){

        listaEventos.remove(idEvento);

    }

    //  MODIFICACION
    public static void modificarEvento(int idEvento, String nombre, String descripcion){

        if (listaEventos.get(idEvento) != null) {

            if (listaEventos.get(idEvento) != null) listaEventos.get(idEvento).setNombre(nombre);
            if (listaEventos.get(idEvento) != null) listaEventos.get(idEvento).setDescripcion(descripcion);

        }else throw new CustomExceptionUsuario("Evento no encontrado");

    }

}

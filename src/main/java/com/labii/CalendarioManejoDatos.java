package com.labii;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by umantram on 27/11/16.
 */
public class CalendarioManejoDatos {

    private static final Map<Integer, Calendario> listaCalendarios  = new HashMap<Integer, Calendario>();
    private static final  AtomicInteger contador = new AtomicInteger(0);

    static {

        Calendario calen1 = new Calendario(contador.incrementAndGet(), "oficina", 1);
        //Calendario calen2 = new Calendario(contador.incrementAndGet(), "Casa", 2);

        listaCalendarios.put(calen1.getidCalendario(), calen1);
        //listaCalendarios.put(calen2.getidCalendario(), calen2);

    };

    public static Collection<Calendario> getListaCalendarios() {
        return listaCalendarios.values();
    }

    public static Calendario getCalendario(Integer idCalendario){

        return listaCalendarios.get(idCalendario);

    }

    //  ALTA
    public static void altaCalendario(String nombre, Integer idUsuario){

        Calendario calendario = new Calendario(contador.incrementAndGet(), nombre, idUsuario);
        listaCalendarios.put(calendario.getidCalendario(), calendario);

    }

    // BAJA
    public static void bajaCalendario(int idCalendario){

        listaCalendarios.remove(idCalendario);

    }

    //  MODIFICACION
    public static void modificarCalendario(int idCalendario, String nombre){

        if (listaCalendarios.get(idCalendario) != null) {

            if (listaCalendarios.get(idCalendario) != null) listaCalendarios.get(idCalendario).setNombre(nombre);

        }else throw new CustomExceptionUsuario("Calendario no encontrado");

    }


}

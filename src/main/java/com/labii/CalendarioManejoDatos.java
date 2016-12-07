package com.labii;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import Exception.CustomExceptionUsuario;
/**
 * Created by umantram on 27/11/16.
 */
public class CalendarioManejoDatos {

    /**
     * listacalendario, es un HashMap que guarda los objetos de tipo Calendario, el cual se lo utiliza como
     * Base de datos, para los AMB(alta, baja, modificar)
     */
    private static final Map<Integer, Calendario> listaCalendarios  = new HashMap<Integer, Calendario>();

    /**
     * AtomicInteger
     *
     * Un valor int que puede actualizarse atómicamente.
     * Un AtomicInteger se utiliza en aplicaciones tales como contadores con incremento atómico
     * y no se puede utilizar como un reemplazo para un entero.
     */
    private static final  AtomicInteger contador = new AtomicInteger(0);

    /**
     * Se crean Instancias iniciales para poder ver el funcionamiento.
     * Estos objetos creados, se cargan al HashMap listaCalendarios
     */

    static {

        Calendario calen1 = new Calendario(contador.incrementAndGet(), "oficina", 1);
        //Calendario calen2 = new Calendario(contador.incrementAndGet(), "Casa", 2);

        listaCalendarios.put(calen1.getidCalendario(), calen1);
        //listaCalendarios.put(calen2.getidCalendario(), calen2);

    };

    /**
     * Metodo que devuelve una Collection de Calendarios.
     */
    public static Collection<Calendario> getListaCalendario() {

        return listaCalendarios.values();
    }

    /**
     * Metodo que devuelve un Obejeto Calendarios que corresponda al idCalendario que se le pasa como Parametro.
     */
    public static Calendario getCalendarioPorID(Integer idCalendario){

        return listaCalendarios.get(idCalendario);

    }

    /**
     * Metodo que genera una nueva Instancia de Calendario, y lo agrega al hashMap
     * los datos que se le pasa por parametros son los Atributos de la Clase.
     */
    public static void altaCalendario(String nombre, Integer idUsuario){

        Calendario calendario = new Calendario(contador.incrementAndGet(), nombre, idUsuario);
        listaCalendarios.put(calendario.getidCalendario(), calendario);

    }

    /**
     * Metodo que elimina un registro del hashMap
     * @param idCalendario
     */
    public static void bajaCalendario(int idCalendario){

        listaCalendarios.remove(idCalendario);

    }

    /**
     * Metodo que modifica un registro del hashMap, que correspnda al idCalendario, y el nuevo valor a asignar
     * @param idCalendario
     * @param nombre
     */
    public static void modificarCalendario(int idCalendario, String nombre){

        if (listaCalendarios.get(idCalendario) != null) {

            if (listaCalendarios.get(idCalendario) != null) listaCalendarios.get(idCalendario).setNombre(nombre);

        }else throw new CustomExceptionUsuario("Calendario no encontrado");

    }


}

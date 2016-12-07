package com.labii;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by umantram on 05/12/16.
 */
public class CalendarioTest extends TestCase {

    @Test
    public static void testCalendario(){

        /**
         *      INSTANCIAS SOBRE LAS CUALES REALIZAREMOS LOS TESTS
         *
         * */
        UsuarioManejoDatos.altaUsuario("juan", "juan@gmail.com");

        Calendario calendario1 = new Calendario(0, "Calendar", 1);
        Calendario calendario2 = new Calendario(1, "MyCalendar", 1);
        Calendario calendario3 = new Calendario(2, "algo", 1);

        /**
             *  TEST DEL METODO getidCalendario()
             *
         * */

        assertEquals(calendario1.getidCalendario(), new Integer(0));
        assertEquals(calendario2.getidCalendario(), new Integer(1));
        assertEquals(calendario3.getidCalendario(), new Integer(2));

        /**
         *      TEST DEL METODO getNombre()
         * */
        assertEquals(calendario1.getNombre(), "Calendar");
        assertEquals(calendario2.getNombre(), "MyCalendar");
        assertEquals(calendario3.getNombre(), "algo");

        /**
         *      TEST DEL METODO getUsuario()
         * */
        assertEquals(calendario1.getUsuario(), UsuarioManejoDatos.getUsuario(1));

        /**
         *      TEST DEL METODO getidUsuario()
         * */
        assertEquals(calendario1.getIdUsuario(), new Integer(1));





    }
}
package com.labii;

import junit.framework.TestCase;

/**
 * Created by francomoglia on 12/3/16.
 */
public class CalendarioManejoDatosTest extends TestCase{

    public static void testCalendarioManejoDatos() throws Exception{

       /**
        *   INSTANCIAMOS UN CALENDARIO PARA PODER TESTEAR LOS METODOS
        * */
       Calendario calendar1 = new Calendario(1, "oficina", 1);

       /**
        *       TESTEO DEL METODO getidCalendario()
        * */
       assertEquals(CalendarioManejoDatos.getCalendarioPorID(1).getidCalendario(), calendar1.getidCalendario());

       /**
        *       TESTEO DEL METODO AltaCalendario()
        * */
        CalendarioManejoDatos.altaCalendario("PruebaAlta", 1);

        Calendario aux = new Calendario(2, "PruebaAlta", 1);

        /**
         *      CHEQUEAMOS CADA ATRIBUTO PARA CORROBORAR QUE EL ALTA FUNCIONO
         * */
        assertEquals(CalendarioManejoDatos.getCalendarioPorID(2).getidCalendario(), aux.getidCalendario());

        assertEquals(CalendarioManejoDatos.getCalendarioPorID(2).getNombre(), aux.getNombre());

        assertEquals(CalendarioManejoDatos.getCalendarioPorID(2).getIdUsuario(), aux.getIdUsuario());


        /**
         *      TEST DEL METODO bajaCalendario()
         * */
        Calendario calendarioAux = CalendarioManejoDatos.getCalendarioPorID(2);
        CalendarioManejoDatos.bajaCalendario(2);

        /**
         *      COMPROBAMOS SI LA BAJA SURTIO EFECTO
         *      COMO EXTRA COMPROBAMOS QUE EL METODO getListaCalendarios()
         *      FUNCIONA CORRECTAMENTE
         * */
        assertTrue(!CalendarioManejoDatos.getListaCalendario().contains(calendarioAux));

        /**
         *      TEST DEL METODO modificarCalendario()
         * */
        CalendarioManejoDatos.modificarCalendario(1, "LAB2APROBADO");

        assertEquals(CalendarioManejoDatos.getCalendarioPorID(1).getNombre(), "LAB2APROBADO");




    }
}
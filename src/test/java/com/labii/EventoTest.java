package com.labii;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by francomoglia on 12/3/16.
 */
public class EventoTest extends TestCase {

    @Test
    public void testEvento() throws Exception{

        Evento evento1 = new Evento(0,"Evento1", "lalala", "rojo",
                new Fecha(3, 12, 2016, 1,56), new Fecha(4,12,2016,1,57), 1);
        Evento evento2 = new Evento(1,"Evento2", "lalala", "azul",
                new Fecha(3, 12, 2016, 1,56), new Fecha(5,12,2016,1,57),1);
        Evento evento3 = new Evento(2,"Evento3", "lalala", "verde",
                new Fecha(3, 12, 2016, 1,56), new Fecha(4,12,2017,1,57),1);

        /*
        *    TEST SOBRE METODO getIdEvento()
        * */
        assertEquals(evento1.getIdEvento(), 0);
        assertEquals(evento2.getIdEvento(), 1);
        assertEquals(evento3.getIdEvento(), 2);


        /*
        *   TEST SOBRE METODO getNombre()
        * */
        assertEquals(evento1.getNombre(), "Evento1");
        assertEquals(evento2.getNombre(), "Evento2");
        assertEquals(evento3.getNombre(), "Evento3");

        /*
        *   TEST SOBRE METODO getIdCalendario()
        * */
        assertEquals(evento1.getIdCalendario(), 0);
        assertEquals(evento2.getIdCalendario(), 0);
        assertEquals(evento3.getIdCalendario(), 1);

        /*
        *   TEST SOBRE METODO getDescripcion()
        * */
        assertEquals(evento1.getDescripcion(), "lalala");
        assertEquals(evento2.getDescripcion(), "lalala");
        assertEquals(evento3.getDescripcion(), "lalala");

        /*
        *   TEST DE LOS METODOS SET
        * */

        evento1.setNombre("Eventitoo");
        evento1.setDescripcion("aloha");
        evento2.setNombre("ElEvento2");
        evento2.setDescripcion("lalala2.0");
        evento3.setNombre("nada");
        evento3.setDescripcion("alla");

        /*
        *   LLAMAMOS A LOS METODOS GET, PARA COMPROBAR
        *   QUE LOS SET ANTERIORES FUNCIONARON
        * */

        assertEquals(evento1.getNombre(), "Eventitoo");
        assertEquals(evento1.getDescripcion(), "aloha");
        assertEquals(evento2.getNombre(), "ElEvento2");
        assertEquals(evento2.getDescripcion(), "lalala2.0");
        assertEquals(evento3.getNombre(), "nada");
        assertEquals(evento3.getDescripcion(), "alla");



    }

}
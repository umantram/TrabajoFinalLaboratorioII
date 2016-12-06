package com.labii;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by francomoglia on 12/3/16.
 */
public class FechaTest extends TestCase {

    @Test
    public void testFecha() throws Exception{

        /*
        *   CREAMOS LAS INSTANCIAS DE LA CLASE FECHA
        *   PARA PODER REALIZAR LOS TEST
        * */
        Fecha fecha1 = new Fecha(3,12,2016,13,18);
        Fecha fecha2 = new Fecha(25,6,1995,20,33);
        Fecha fecha3 = new Fecha(3,3,2003,3,33);


        /*
        *   REALIZAMOS LOS TEST SOBRE EL METODO getDia()
        * */
        assertEquals(fecha1.getDia(), 3);
        assertEquals(fecha2.getDia(), 25);
        assertEquals(fecha3.getDia(), 3);

        /*
        *   TEST DEL METODO getMes()
        * */
        assertEquals(fecha1.getMes(), 12);
        assertEquals(fecha2.getMes(), 6);
        assertEquals(fecha3.getMes(), 3);

        /*
        *   TEST DEL METODO getAnio()
        * */
        assertEquals(fecha1.getAnio(), 2016);
        assertEquals(fecha2.getAnio(), 1995);
        assertEquals(fecha3.getAnio(), 2003);

        /*
        *   TEST DEL METODO getHora()
        * */
        assertEquals(fecha1.getHora(), 13);
        assertEquals(fecha2.getHora(), 20);
        assertEquals(fecha3.getHora(), 3);

        /*
        *   TEST DEL METODO getMinutos()
        * */
        assertEquals(fecha1.getMinutos(), 18);
        assertEquals(fecha2.getMinutos(), 33);
        assertEquals(fecha3.getMinutos(), 33);


        /*
        *   TEST DE LOS SETTERS
        * */
        fecha1.setDia(15);
        fecha1.setMes(1);
        fecha1.setAnio(2017);
        fecha1.setHora(5);
        fecha1.setMinutos(10);

        fecha2.setDia(10);
        fecha2.setMes(3);
        fecha2.setAnio(1870);
        fecha2.setHora(4);
        fecha2.setMinutos(11);

        fecha3.setDia(18);
        fecha3.setMes(9);
        fecha3.setAnio(2002);
        fecha3.setHora(23);
        fecha3.setMinutos(0);

        /*
        *   TEST DEL METODO setDia()
        * */
        assertEquals(fecha1.getDia(), 15);
        assertEquals(fecha2.getDia(), 10);
        assertEquals(fecha3.getDia(), 18);

        /*
        *   TEST DEL METODO setMes()
        * */
        assertEquals(fecha1.getMes(), 1);
        assertEquals(fecha2.getMes(), 3);
        assertEquals(fecha3.getMes(), 9);

        /*
        *   TEST DEL METODO setAnio()
        * */
        assertEquals(fecha1.getAnio(), 2017);
        assertEquals(fecha2.getAnio(), 1870);
        assertEquals(fecha3.getAnio(), 2002);

        /*
        *   TEST DEL METODO setHora()
        * */
        assertEquals(fecha1.getHora(), 5);
        assertEquals(fecha2.getHora(), 4);
        assertEquals(fecha3.getHora(), 23);

        /*
        *   TEST DEL METODO setMinutos()
        * */
        assertEquals(fecha1.getMinutos(), 10);
        assertEquals(fecha2.getMinutos(), 11);
        assertEquals(fecha3.getMinutos(), 0);

    }
}
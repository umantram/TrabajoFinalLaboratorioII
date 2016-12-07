package com.labii;

import com.labii.comparadores.ComparadorEventos;
import junit.framework.TestCase;

/**
 * Created by francomoglia on 12/3/16.
 */
public class EventoManejoDatosTest extends TestCase {

    public void testEventoManejoDatos() throws Exception{

        /**
         *      INSTANCIAMOS LA CLASE EVENTO
         * */
        Evento evento = new Evento(2, "MyEvent", "Prueba", "rojzul",
                new Fecha(16,12,2016,1,30),
                new Fecha(17,12,2016,16,25), 1);
        /**
         *      TESTEAMOS EL METODO altaEvento
         * */
        EventoManejoDatos.altaEvento("MyEvent", "Prueba", "rojzul",
                16,12,2016,1,30,
                17,12,2016,16,25, 1);

        /**
         *      UTILIZAMOS UN AYUDANTE PARA PODER COMPARAR DOS EVENTOS
         * */
        ComparadorEventos ayudanteEventos = new ComparadorEventos();

        /**
         *      SEGUN EL AYUDANDO CREADO ANTERIORMENTE, SI ESTE DEVUELVE UN 0,
         *      CON SU METODO compare() QUIERE DECIR QUE LOS EVENTOS SON IGUALES
         *      POR LO TANTO, QUIERE DECIR QUE FUE UN EXITO NUESTRO altaEvento()
         * */
        assertTrue(ayudanteEventos.compare(EventoManejoDatos.getEventos(2), evento) == 0);

        /**
         *      TESTEO DEL METODO bajaEvento()
         * */
        Evento eventoAux = EventoManejoDatos.getEventos(2);
        EventoManejoDatos.bajaEvento(2);

        assertTrue(!EventoManejoDatos.getListaEventos().contains(eventoAux));


        /**
         *      TESTEO DEL METODO modificarEvento()
         * */

        /**
         *      CREAMOS UNA NUEVA INSTANCIA DE EVENTO PARA COMPARAR
         *      Y VER SI EL METODO modificarEvento() FUNCIONA
         * */
        Evento evento2 = new Evento(1, "FirmarLibretaPorLab2" ,
                "Facundo y Dario me regularizaron, VAMOS MANAOS", "Rojo",
                new Fecha(10,01,2016,20,30),
                new Fecha(10,01,2016,21,30),1);

        /**
         *      REALIZAMOS LA MODIFICACION EN EL EVENTO
         * */
        EventoManejoDatos.modificarEvento(1, "FirmarLibretaPorLab2",
                "Facundo y Dario me regularizaron, VAMOS MANAOS");

        /**
         *      UTILIZAMOS NUEVAMENTE EL AYUDANTE PARA COMPARAR LOS EVENTOS
         *      Y VER SI SON IGUALES, DE ESTE MODO SABREMOS SI NUESTRA MODIFICACION
         *      SURTIO EFECTO O NO
         * */
        assertTrue(ayudanteEventos.compare(EventoManejoDatos.getEventos(1), evento2) == 0);


    }



}
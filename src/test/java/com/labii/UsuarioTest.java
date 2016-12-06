package com.labii;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by francomoglia on 12/3/16.
 */
public class UsuarioTest extends TestCase{

    @Test
    public void testUsuario() throws Exception{

        /*
            CREAMOS TRES INSTANCIAS DE LA CLASE USUARIO,
            CON LOS RESPECTIVOS VALORES DEL CONSTRUCTOR
         */
        Usuario usuario1 = new Usuario(0, "juan", "juanElCartero@gmail.com");
        Usuario usuario2 = new Usuario(1, "pepe", "pepelotas@gmail.com");
        Usuario usuario3 = new Usuario(456, "roberto", "elquetedejo...@yaju.com");


        /*
        *   REALIZAMOS EL TEST SOBRE EL METODO getIdUsuario()
        * */
        assertEquals(usuario1.getIdUsuario(), 0);
        assertEquals(usuario2.getIdUsuario(), 1);
        assertEquals(usuario3.getIdUsuario(), 456);


        /*
        *   IDEM ANTERIOR
        *   TEST getEmail()
        * */
        assertEquals(usuario1.getEmail(), "juanElCartero@gmail.com");
        assertEquals(usuario2.getEmail(), "pepelotas@gmail.com");
        assertEquals(usuario3.getEmail(), "elquetedejo...@yaju.com");

        /*
        *   IDEM ANTERIOR
        *   TEST getNombre()
        * */
        assertEquals(usuario1.getNombre(), "juan");
        assertEquals(usuario2.getNombre(), "pepe");
        assertEquals(usuario3.getNombre(), "roberto");


        /*
        *   SETEAMOS VALORES CON EL METODO setNombre()
        *   PARA LUEGO COMPROBAR SI SU FUNCIONAMIENTO
        *   ES CORRECTO.
        * */
        usuario1.setNombre("carlos");
        usuario2.setNombre("raul");
        usuario3.setNombre("alberto");

        /*
        *   TEST DE FUNCIONAMINETO METODO setNombre()
        * */
        assertEquals(usuario1.getNombre(), "carlos");
        assertEquals(usuario2.getNombre(), "raul");
        assertEquals(usuario3.getNombre(), "alberto");


        /*
        *   IDEM ANTERIOR
        *   TEST setEmail()
        * */
        usuario1.setEmail("carlitos@algo.com");
        usuario2.setEmail("raulito@algo.com");
        usuario3.setEmail("albertito@algo.com");


        /*
        *   TEST DE FUNCIONAMIENTO setEmail()
        * */
        assertEquals(usuario1.getEmail(), "carlitos@algo.com");
        assertEquals(usuario2.getEmail(), "raulito@algo.com");
        assertEquals(usuario3.getEmail(), "albertito@algo.com");
    }
}
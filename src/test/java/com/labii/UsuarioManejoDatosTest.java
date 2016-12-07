package com.labii;

import com.labii.comparadores.ComparadorUsuarios;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by francomoglia on 12/3/16.
 */
public class UsuarioManejoDatosTest extends TestCase{

    @Test
    public static void testUsuarioManejoDatos() throws Exception{

        Usuario user1 = new Usuario(2, "Roberto", "roberto11@gmail.com");

        /**
         *      DAMOS DE ALTA UN USUARIO PARA PROBAR LOS METODOS
         *      DE LA CLASE UsuarioManejoDatos
         * */
        UsuarioManejoDatos.altaUsuario("Roberto", "roberto11@gmail.com");

        /**
         *      COMPROBAMOS LOS DATOS PASADOS COMO PARAMETROS AL
         *      METODO altaUsuario()
         * */
        assertEquals(UsuarioManejoDatos.getUsuario(2).getIdUsuario(), user1.getIdUsuario());

        assertEquals(UsuarioManejoDatos.getUsuario(2).getEmail(), user1.getEmail());

        assertEquals(UsuarioManejoDatos.getUsuario(2).getNombre(), user1.getNombre());

        /**
         *      COMPROBAMOS EL METODO bajaUsuario()
         *      COMO EXTRA, SE COMPRUEBA EL CORRECTO
         *      FUNCIONAMIENTO DEL METODO
         *      getUsuarios()
         * */

        Usuario aux = UsuarioManejoDatos.getUsuario(2);
        UsuarioManejoDatos.bajaUsuario(2);

        assertTrue(!UsuarioManejoDatos.getListaUsuario().contains(aux));

        //assertTrue(UsuarioManejoDatos.getUsuario(2) == null);

        /**
         *      COMPROBAMOS EL METODO modifUsuario()
         * */
        UsuarioManejoDatos.modificarUsuario(1, "umantram@no-reply.com");

        assertEquals(UsuarioManejoDatos.getUsuario(1).getEmail(), "umantram@no-reply.com");

        /**
         *      COMPROBACION DEL METODO getUsuario()
         * */
        Usuario usuario1 = new Usuario(1, "Andres", "umantram@no-reply.com");

        /**
         *      USAMOS UN AYUDANTE, EL CUAL ES UNA INSTANCIA DE UNA CLASE
         *      QUE IMPLEMENTA LA INTERFACE Comparable<T>, DE ESTA FORMA
         *      PODEMOS SOBRESCRIBIR EL METODO compareTo, PARA COMPARAR
         *      DOS OBJETOS, SEGUN NUESTROS PROPIOS CRITERIOS
         * */
        ComparadorUsuarios ayudante = new ComparadorUsuarios();

        assertTrue(ayudante.compare(UsuarioManejoDatos.getUsuario(1), usuario1) == 0);

    }


}
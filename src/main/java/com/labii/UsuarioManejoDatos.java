package com.labii;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import Exception.CustomExceptionUsuario;

/**
 * Created by umantram on 27/11/16.
 */
public class UsuarioManejoDatos {

    /**
     * listusuarios, es un HashMap que guarda los objetos de tipo Usuario, el cual se lo utiliza como
     * Base de datos, para los AMB(alta, baja, modificar)
     */
    private static final Map<Integer, Usuario> listusuarios = new HashMap<Integer, Usuario>();

    /**
     * AtomicInteger
     *
     * Un valor int que puede actualizarse atómicamente.
     * Un AtomicInteger se utiliza en aplicaciones tales como contadores con incremento atómico
     * y no se puede utilizar como un reemplazo para un entero.
     */
    private static final AtomicInteger contador = new AtomicInteger(0);

    /**
     * Se crean Instancias iniciales para poder ver el funcionamiento.
     * Estos objetos creados que cargan al HashMap listusuarios
     */
    static  {

        Usuario usuario1 = new Usuario(contador.incrementAndGet(), "Andres", "umantram");
        //Usuario usuario2 = new Usuario(contador.incrementAndGet(), "Gran", "artigues");

        listusuarios.put(usuario1.getIdUsuario(), usuario1);
        //listusuarios.put(usuario2.getIdUsuario(), usuario2);

    }

    /**
     * Metodo que devuelve un Obejeto Usaurio que corresponda al idUsuario que se le pasa como Parametro.
     */
    public static Usuario getUsuario(int idUsuario){

        if (listusuarios.get(idUsuario) != null){
            return listusuarios.get(idUsuario);
        }else throw new CustomExceptionUsuario("Usuario Inexistente");

    }

    /**
     * Metodo que devuelve una Collection de Usaurios.
     */
    public static Collection<Usuario> getListaUsuario(){

        if (!listusuarios.values().isEmpty()){
            return listusuarios.values();
        }else throw new CustomExceptionUsuario("Coleccion vacia");

    }

    /**
     * Metodo que genera una nueva Instancia de Usuario, y lo agrega al hashMap
     * los datos que se le pasa por parametros son los Atributos de la Clase.
     */
    public static void altaUsuario(String nombre, String email){

        Usuario aux = new Usuario(contador.incrementAndGet(), nombre, email);
        listusuarios.put(aux.getIdUsuario(), aux);

    }

    /**
     * Metodo que elimina un registro del hashMap
     * @param idUsuario
     */
    public static void bajaUsuario(int idUsuario){

        listusuarios.remove(idUsuario);

    }

    /**
     * Metodo que modifica un registro del hashMap, que correspnda al idUsuario, y el nuevo valor a asignar
     * @param idUsuario
     * @param email
     */
    public static void modificarUsuario(int idUsuario, String email){

        if (listusuarios.get(idUsuario) != null) {
            listusuarios.get(idUsuario).setEmail(email);
        }else throw new CustomExceptionUsuario("Usuario no encontrado");

    }
}


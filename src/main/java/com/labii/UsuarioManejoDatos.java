package com.labii;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by umantram on 27/11/16.
 */
public class UsuarioManejoDatos {

    private static final Map<Integer, Usuario> listusuarios = new HashMap<Integer, Usuario>();
    private static final AtomicInteger contador = new AtomicInteger(0);

    static  {

        Usuario usuario1 = new Usuario(contador.incrementAndGet(), "Andres", "umantram");
        //Usuario usuario2 = new Usuario(contador.incrementAndGet(), "Gran", "artigues");

        listusuarios.put(usuario1.getIdUsuario(), usuario1);
        //listusuarios.put(usuario2.getIdUsuario(), usuario2);

    }

    public static Usuario getUsuario(int idusuario){

        if (listusuarios.get(idusuario) != null){
            return listusuarios.get(idusuario);
        }else throw new CustomExceptionUsuario("Usuario Inexistente");

    }

    public static Collection<Usuario> getUsuarios(){

        if (!listusuarios.values().isEmpty()){
            return listusuarios.values();
        }else throw new CustomExceptionUsuario("Coleccion vacia");

    }

    //  ALTA
    public static void altaUsuario(String nombre, String email){

        Usuario aux = new Usuario(contador.incrementAndGet(), nombre, email);
        listusuarios.put(aux.getIdUsuario(), aux);

    }

    // BAJA
    public static void bajaUsuario(int idUsuario){

        listusuarios.remove(idUsuario);

    }

    //  MODIFICACION
    public static void modifUsuario(int idUsuario, String email){

        if (listusuarios.get(idUsuario) != null) {
            listusuarios.get(idUsuario).setEmail(email);
        }else throw new CustomExceptionUsuario("Usuario no encontrado");

    }
}


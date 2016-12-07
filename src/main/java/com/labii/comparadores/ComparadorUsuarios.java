package com.labii.comparadores;

import com.labii.Usuario;

import java.util.Comparator;

/**
 * Created by francomoglia on 12/6/16.
 */
    public class ComparadorUsuarios implements Comparator<Usuario> {

        @Override
        public int compare(Usuario o1, Usuario o2) {

            if (o1.getIdUsuario() == o2.getIdUsuario()){
                if (o1.getEmail().equals(o2.getEmail())){
                    if (o1.getNombre().equals(o2.getNombre())){
                        return 0;
                    }
                    return -1;
                }
                return -1;
            }
            return -1;
        }

}

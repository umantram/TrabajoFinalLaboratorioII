package com.labii.comparadores;

import com.labii.Calendario;

import java.util.Comparator;

/**
 * Created by francomoglia on 12/6/16.
 */
public class ComparadorCalendarios implements Comparator<Calendario>{

    @Override
    public int compare(Calendario o1, Calendario o2) {

        if (o1.getidCalendario() == o2.getidCalendario()){
            if (o1.getNombre().equals(o2.getNombre())){
                if (o1.getIdUsuario() == o2.getIdUsuario()){
                    return 0;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }
}

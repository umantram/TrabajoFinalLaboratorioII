package com.labii.comparadores;

import com.labii.Evento;

import java.util.Comparator;

/**
 * Created by francomoglia on 12/6/16.
 */
public class ComparadorEventos implements Comparator<Evento> {

    @Override
    public int compare(Evento o1, Evento o2) {

        ComparadorFechas ayudanteFechas = new ComparadorFechas();

        if (o1.getNombre().equals(o2.getNombre())){
            if (o1.getDescripcion().equals(o2.getDescripcion())){
                if (o1.getColor().equals(o2.getColor())){
                    if (ayudanteFechas.compare(o1.getFechaInicio(), o2.getFechaInicio()) == 0){
                        if (ayudanteFechas.compare(o1.getFechaFin(), o2.getFechaFin()) == 0){
                            if (o1.getIdCalendario() == o2.getIdCalendario()){
                                return 0;
                            }else return 1;
                        }else return 1;
                    }else return 1;
                }else return 1;
            }else return 1;
        }else return 1;
    }
}

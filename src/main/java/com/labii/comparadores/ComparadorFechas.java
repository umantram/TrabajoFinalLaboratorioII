package com.labii.comparadores;

import com.labii.Fecha;

import java.util.Comparator;

/**
 * Created by francomoglia on 12/6/16.
 */
public class ComparadorFechas implements Comparator<Fecha> {

    @Override
    public int compare(Fecha o1, Fecha o2) {
        if (o1.getDia() == o2.getDia()){
            if (o1.getMes() == o2.getMes()){
                if (o1.getAnio() == o2.getAnio()){
                    if (o1.getHora() == o2.getHora()){
                        if (o1.getMinutos() == o2.getMinutos()){
                            return 0;
                        }else return 1;
                    }else return 1;
                }else return 1;
            }else return 1;
        }   else return 1;
    }
}

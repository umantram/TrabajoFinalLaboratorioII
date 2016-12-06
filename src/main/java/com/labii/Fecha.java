package com.labii;

/**
 * Created by francomoglia on 11/28/16.
 */

public class Fecha {

    //      ATRIBUTOS
    private int dia;
    private int mes;
    private int anio;
    private int hora;
    private int minutos;


    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public Fecha(int dia, int mes, int anio, int hora, int minutos){

        /**
         *  SI NO QUEREMOS CAMBIAR EL ORDEN DEL INGRESO DE DATOS, USAMOS VARIABLES AUXILIARES
         *  Y QUE LUEGO EL CODIGO SE ENCARGUE DE VALIDAR LOS DATOS
         */

        if (mes > 0 && mes <= 12){
            this.mes = mes;
        }else throw new CustomExceptionUsuario("Mes invalido");


        /*
        *   CHEQUE DE VALIDACION DEL DIA DEL MES INGRESADO
        * */
        if (mes31Dias()){
            if (dia > 0 && dia <= 31){
                this.dia = dia;
            }else throw new CustomExceptionUsuario("Dia Invalido, el mes ingresado solo tiene 31 dias");
        }else if (mes30Dias()){
            if (dia > 0 && dia < 31){
                this.dia = dia;
            }else throw new CustomExceptionUsuario("Dia invalido, el mes ingresado solo tiene 30 dias");
        }else if (febrero29Dias()){
            if (dia > 0 && dia < 30){
                this.dia = dia;
            }else throw new CustomExceptionUsuario("Dia invalido, año bisiesto, febrero solo tiene 29 dias");
        }else if (febrero28Dias()){
            if (dia > 0 && dia < 29){
                this.dia = dia;
            }else throw new CustomExceptionUsuario("Dia invalido, no es año bisiesto, febrero solo tiene 28 días");
        }

        if (hora >= 0 && hora < 24) {
            this.hora = hora;
        }else {
            throw new IllegalArgumentException("Hora Invalida");
        }

        if (minutos >= 0 && minutos < 60) {
            this.minutos = minutos;
        }else {
            throw new IllegalArgumentException("Minutos Invalidos");
        }

        /*
        *   Acotamos el rango de años, [ 1950 ; 2050 ]
        * */

        if (anio >= 1950 && anio <= 2050){
            this.anio = anio;
        }else throw new CustomExceptionUsuario("Año incorrecto");


    }

    public Fecha(){

    }
    @Override
    public String toString() {

        if (minutos > 0 && minutos < 10) {
            return "Fecha: " + dia + "/" + mes + "/" + anio + "\n" +
                    "Hora: " + hora + ":0" + minutos;
        } else return "Fecha: " + dia + "/" + mes + "/" + anio + "\n" +
                "Hora: " + hora + ":" + minutos;
    }

    public boolean mes30Dias(){

        if (this.mes == 11 || this.mes == 9 || this.mes == 6 || this.mes == 4){
            return true;
        }else return false;


    }

    public boolean mes31Dias(){

        if (this.mes == 12 || this.mes == 10 || this.mes == 8 || this.mes == 7 ||
                this.mes == 5 || this.mes == 3 || this.mes == 1){
            return true;
        }else return false;
    }

    public boolean febrero28Dias(){
        if (this.mes == 2){
            return true;
        }else return false;
    }

    public boolean febrero29Dias(){

        if (this.mes == 2 && anioBisiesto()){
            return true;
        }else return false;
    }

    public boolean anioBisiesto(){

        if ((this.anio % 4 == 0 && this.anio % 100 != 0) || (this.anio % 4 == 0 && this.anio % 100 == 0 && this.anio % 400 == 0)){
            return true;
        }else return false;

    }

}